package test;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.HashMap;

import java.util.Scanner;

import java.util.Set;

//https://blog.csdn.net/qq_46539113/article/details/114603368
//原创

//https://blog.csdn.net/weixin_30856775/article/details/116009213
//copy， 而且格式不好
public class CountKeywords {
    private static HashMap<String ,Integer> records = new HashMap<>();//用于存储关键字

    /**
     * 获取关键字
     */

    private static void getKeywords() {
        /*

         *在程序中，不要直接使用绝对文件名。如果使用了像 c:\\book\\Welcome.java 之类的文

         *件名，那么它能在 Windows上工作，但是不能在其他平台上工作。应该使用与当前目录相

         * 关的文件名。例如，可以使用 new File("welcome.java")为在当前目录下的文件 Welcome.java

         * 创建一个 File 对象。可以使用 new File("image/us.gif")为在当前目录下的 image目

         * 录下的文件 us.gif创建一个 File 对象。斜杠(/)是 Java 的目录分隔符，这点和 UNIX 是一样的。

         * 语句 new File(image/us.gif")在 Windows、UNIX 或任何其他系统上都能工作。

         */

        File file = new File("src/count/keywords.txt");//通过存储关键字的文本文件获取关键字并存储

        if (!file.exists()) {
            System.err.println("Keywords-file does not exist!");

            System.exit(0);

        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                records.put(scanner.next(), 0);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }

    static {
        getKeywords();

    }

    public static void main(String[] args) {
        File file = new File(args[0]);

        if (!file.exists()) {//对输入的“命令行”路径参数进行检验

            System.err.println("File or directory does not exist!");

            System.exit(0);

        } else {
            checkAndCountFromFile(args[0]);

        }

        Set<String > keywordsSet = records.keySet();

        for (String keyword : keywordsSet) {//遍历统计的各个关键字的结果

            System.out.println(keyword + " : " + records.get(keyword));

        }

    }

    /**
     * 统计.java文件中各个关键字的个数
     * <p>
     * 若是目录则获取目录下的所有子文件或子目录的绝对路径递归调用该方法，对.java文件和子目录中.java进行统计
     * <p>
     * 若是.java文件则直接统计
     *
     * @param path 文件或目录的绝对路径
     */

    private static void checkAndCountFromFile(String path) {
        File[] files;

        File file = new File(path);

        if (file.isDirectory()) {
            //若是目录则获取目录下的所有子文件或子目录的绝对路径递归调用该方法，对.java文件和子目录中.java进行统计

            files = file.listFiles();

            for (File value : files) {
                checkAndCountFromFile(value.getAbsolutePath());

            }

        } else if (file.isFile()) {//若是.java文件则直接统计

            if (file.getName().endsWith(".java")) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNext()) {
                        checkAndCountFromStr(scanner.next());

                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();

                }

            }

        }

    }

    /**
     * 检查从Java源文件中逐个读取的字符串并且对关键字逐个统计数目
     *
     * @param string 从Java源文件中逐个读取的字符串
     */

    private static void checkAndCountFromStr(String string) {
        if (records.containsKey(string)) records.put(string, records.get(string) + 1);

        switch (string) {
            case "(true)":

                records.put("true", records.get("true") + 1);

                break;

            case "break;":

                records.put("break", records.get("break") + 1);

                break;

            case "continue;":

                records.put("continue", records.get("continue") + 1);

                break;

        }

        if (string.length() > 6) {
            if (string.substring(0, 6).equals("super.")) records.put("super", records.get("super") + 1);

            if (string.substring(0, 5).equals("this.")) records.put("this", records.get("super") + 1);

        }

    }

}