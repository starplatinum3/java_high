package test;

//public class FileTest {
//}

import java.io.File;
//package com.wangpaidog.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileTest {
//    在文件里查找 文字 ,查找一个目录
    public static void main(String[] args) {
        FileTest.showFileName("E:\\JavaBase\\spaceManagement\\src\\main\\webapp",
                "login", "css", "jsp", "java");

    }

    /***
     *@parampath 传入文件目录
     *@paramfindContent 传入查找内容
     *@paramfilestyle 传入查找的文件格式 --其实是文件名包含的字段*/

    public static void showFileName(String path, String findContent, String... filestyle) {
        File file = new File(path);
        if (file.exists() && file.isDirectory()) { //判断目录存在

            File[] files = file.listFiles();
            if (files == null) { //如果文件夹无权访问会返回空，文件可以用canRead()

                System.out.println("无权限访问目录");
                return;

            }/** 遍历输出文件*/

            for (File file1 : files) {//目录文件，继续迭代

                if (file1.isDirectory()) {
                    showFileName(file1.toString(), findContent, filestyle);

                } else if (file1.isHidden()) {
                    //System.out.println("隐藏文件： " + file1.getName());

                } else {//可访问显式文件//这里设置了文件类型

                    for (String style : filestyle) {
                        if (file1.getName().contains(style)) {
                            String str = file1.getPath();
                            try {//调用函数查询

                                FileTest.findFile(str, findContent);

                            } catch (Exception e) {
                                e.printStackTrace();

                                System.out.println("出错了");

                            }

                        }

                    }

                }

            }

        }

    }

    /***
     *@paramfilename 文件名称
     *@paramstr 查找的内容
     *@throwsException*/

    private static void findFile(String filename, String findContent) throws Exception {
        File file = new File(filename);

        InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);

        BufferedReader buff = new BufferedReader(read);

        String linexTxt = null; //用于放置读取到的每一行

        int i = 0; //用于记录找到的行数

        while ((linexTxt = buff.readLine()) != null) {
            i++;
            if (linexTxt.contains(findContent)) {
                System.out.println(filename + ":::::" + i);

            }

        }

        buff.close();

        read.close();

    }

}
//        ————————————————
//        版权声明：本文为CSDN博主「燕梳楼」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/weixin_42298105/article/details/114498569