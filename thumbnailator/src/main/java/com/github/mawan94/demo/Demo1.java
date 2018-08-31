package com.github.mawan94.demo;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;


public class Demo1 {
    public static void main(String[] args) throws IOException {
        //压缩图片文件大小 scale 图片比例缩放（主要因素） outputQuality参数1为最高质量
        Thumbnails.of(new File("C:\\Users\\PSDZ\\Desktop\\生产订单列表\\1.png")).scale(1f).outputQuality(1f)
                .toFile(new File("C:\\Users\\PSDZ\\Desktop\\生产订单列表\\11.png"));

        int i = 10;
        System.out.println(i << 1 >> 2);
        int j = 9;
        System.out.println(j >> 1);

        System.out.println(2 << 2);
    }

}
