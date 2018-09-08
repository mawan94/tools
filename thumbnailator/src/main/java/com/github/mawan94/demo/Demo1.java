package com.github.mawan94.demo;

import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;


public class Demo1 {
    public static void main(String[] args) throws IOException {
//        //压缩图片文件大小 scale 图片比例缩放（主要因素） outputQuality参数1为最高质量
        Thumbnails.of(new File("C:\\Users\\PSDZ\\Desktop\\生产订单列表\\1.png")).scale(1f).outputQuality(1f)
                .toFile(new File("C:\\Users\\PSDZ\\Desktop\\生产订单列表\\11.png"));

        int i = 10;
        System.out.println(i << 1 >> 2);
        int j = 9;
        System.out.println(j >> 1);

        System.out.println(2 << 2);

    }
}



// 时钟
class HyClock extends JFrame implements Runnable {
    public static JLabel tm;
    public void run() {
        while (true) {
            Calendar c = Calendar.getInstance();
            String nowtime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
            tm.setText(nowtime);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] agrs) {
        HyClock  hytime = new HyClock();
        hytime.setLayout(new FlowLayout());
        tm = new JLabel();
        tm.setFont(new Font("宋体", 1, 40));
        tm.setForeground(Color.RED);
        hytime.add(tm);
        hytime.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        hytime.setSize(300, 100);
        hytime.setVisible(true);
        hytime.setLocation(400, 400);
        Thread t = new Thread(hytime);
        t.start();
    }
}
