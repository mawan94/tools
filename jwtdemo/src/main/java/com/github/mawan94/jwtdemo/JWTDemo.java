/**
 * Copyright (C), 2015-2019, MaWan
 * FileName: JWTDemo
 * Author:   MaWan
 * Date:     2019/2/12 20:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.github.mawan94.jwtdemo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author : MaWan
 * @create : 2019/2/12
 * @since 1.0.0
 */
public class JWTDemo {
    public String createToken() {
        try {
            String secret = "secret";//token密钥
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 构建header信息
            Map<String, Object> map = new HashMap<>();
            map.put("alg", "HS256");
            map.put("typ", "JWT");

            Date nowDate = new Date();
            Date expireDate = getAfterDate(nowDate, 0, 0, 0, 0, 0, 1);//2小过期
            String token = JWT.create()
                    /*------  设置头信息Header  ------*/
                    .withHeader(map)
                    /*------  设置载荷 Payload  ------*/
                    /*自定义信息*/
                    .withClaim("name", "zhangsan")
                    .withClaim("role", "admin")
                    /*签发人*/
                    .withIssuer("SERVICE")
                    /*主题*/
                    .withSubject("test demo")
                    //.withNotBefore(new Date())//定义在什么时间之前，该jwt都是不可用的.
                    /*受众 也可以理解谁接受签名的*/
                    .withAudience("PC_BACKEND")
                    /*生成签名的时间*/
                    .withIssuedAt(nowDate)
                    /*签名过期的时间*/
                    .withExpiresAt(expireDate)
                    /*------  签名 Signature  ------*/
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void verifyToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier  = JWT.require(algorithm)
                    .withIssuer("SERVICE")
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> claims =jwt.getClaims();
            //-----------------业务-----------------------
            Claim name = claims.get("name");
            Claim role = claims.get("role");
            System.out.println(name.asString());
            System.out.println(role.asString());
            //----------------------------------------
            List<String> audience = jwt.getAudience();
            System.out.println(jwt.getSubject());
            System.out.println(audience);
            System.out.println(audience.get(0));
        }catch (JWTVerificationException e){
            e.printStackTrace();
        }
    }

    /**
     * 返回一定时间后的日期
     *
     * @param nowDate 开始计时的时间
     * @param year    增加的年
     * @param month   增加的月
     * @param day     增加的日
     * @param hour    增加的小时
     * @param minute  增加的分钟
     * @param second  增加的秒
     * @return
     */
    private Date getAfterDate(Date nowDate, int year, int month, int day, int hour, int minute, int second) {
        if (nowDate == null) {
            nowDate = new Date();
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(nowDate);
        if (year != 0) {
            cal.add(Calendar.YEAR, year);
        }
        if (month != 0) {
            cal.add(Calendar.MONTH, month);
        }
        if (day != 0) {
            cal.add(Calendar.DATE, day);
        }
        if (hour != 0) {
            cal.add(Calendar.HOUR_OF_DAY, hour);
        }
        if (minute != 0) {
            cal.add(Calendar.MINUTE, minute);
        }
        if (second != 0) {
            cal.add(Calendar.SECOND, second);
        }
        return cal.getTime();
    }

    public static void main(String[] args) {
        JWTDemo demo = new JWTDemo();
        String token = demo.createToken();
        System.out.println(token);
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo.verifyToken(token);
    }
}