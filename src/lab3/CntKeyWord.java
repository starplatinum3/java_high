package lab3;

import java.util.*;

public class CntKeyWord {
    static String[] keywordString = {"abstract", "finally", "public",
            "boolean", "float", "return", "break", "for", "short", "byte",
            "goto", "static", "case", "if", "super", "catch", "implements",
            "switch", "char", "import", "synchronized", "class",
            "instanceof", "this", "const", "int", "throw", "continue",
            "interface", "throws", "default", "long", "transient", "do",
            "native", "try", "double", "new", "void", "else", "package",
            "volatile", "extends", "private", "while", "final",
            "protected", "true", "null"};

    static void parseSplits(String str, Flag flag, List<String> tokens,
                            Map<String, Integer> map) {
//        if (str.contains("if")) {
//            System.out.println("str");
//            System.out.println(str);
//            System.out.println("quatationFlag");
//            System.out.println(flag.getQuatationFlag());
//            System.out.println("cmtFlag");
//            System.out.println(flag.getCmtFlag());
//            System.out.println("lineCmtFlag");
//            System.out.println(flag.getLineCmtFlag());
//        }

        if (str.equals("\"")) {
            if (flag.getQuatationFlag() == 0) {
//                quatationFlag = 1;
                flag.setQuatationFlag(1);
            } else {
//                quatationFlag = 0;
                flag.setQuatationFlag(0);
//                    可以
//                    if (map.containsKey(str)) {
//                        map.put(str, map.get(str) + 1);
//                    } else {
//                        map.put(str, 1);
//                    }
            }

        } else if (str.equals("/*")) {
//            cmtFlag=1;
            flag.setCmtFlag(1);
//                if (cmtFlag == 0) {
//                    cmtFlag = 1;
//                } else {
//                    cmtFlag = 0;
////                    可以
////                    if (map.containsKey(str)) {
////                        map.put(str, map.get(str) + 1);
////                    } else {
////                        map.put(str, 1);
////                    }
//                }
        } else if (str.equals("*/")) {
//            cmtFlag=0;
            flag.setCmtFlag(0);
//                if (cmtFlag == 0) {
//                    cmtFlag = 1;
//                } else {
//                    cmtFlag = 0;
////                    可以
////                    if (map.containsKey(str)) {
////                        map.put(str, map.get(str) + 1);
////                    } else {
////                        map.put(str, 1);
////                    }
//                }
        } else if (str.equals("//")) {
//            这个if 被 不要了 ,因为有// ,我的算法问题
//            lineCmtFlag=1;
            flag.setLineCmtFlag(1);
//            }else if(str.equals("\n")&&lineCmtFlag==1){
        }
//        else if(str.equals("\n")){
////            line 结束了 就 setLineCmtFlag =0 ,但是不是在这里
////                回车不会被作为一个 东西读入
////            lineCmtFlag=0;
//            flag.setLineCmtFlag(0);
//        }

        if (!tokens.contains(str)) {
            return;
        }
        if (flag.getCmtFlag() == 1 || flag.getQuatationFlag() == 1
                || flag.getLineCmtFlag() == 1) {
//            continue;
            return;
        }
        if (map.containsKey(str)) {
            map.put(str, map.get(str) + 1);
        } else {
            map.put(str, 1);
        }
    }

   static void testSub(){
        String string="line.indexOf(\"//\");";
       int i = string.indexOf("//");
//       System.out.println(string.substring(i));
       System.out.println(string.substring(i+2));
//       ");
   }
    static void parseLine(String line, Map<String, Integer> map, Flag flag,
                          List<String> tokens) {
        int i = line.indexOf("//");
        if (i != -1) {
//            line=line.substring(i+2);
            line=line.substring(0,i);
//            不是 注释后面 而是前面
//            return;
        }
        String[] split = line.split(" ");
        for (String str : split) {
            parseSplits(str, flag, tokens, map);
        }
        flag.setLineCmtFlag(0);

    }

    static  void cntKeyWords(){
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        List<String> list = Arrays.asList(keywordString);
//        List<String> list = new ArrayList<>(Arrays.asList(keywordString));
//        int quatationFlag = 0;
//        int cmtFlag = 0;
//        int lineCmtFlag = 0;
        Flag flag = new Flag(0, 0, 0);
//        while (scanner.hasNext()) {
        while (scanner.hasNextLine()) {

//            String str = scanner.next();
//            String line = scanner.nextLine();
            String str = scanner.nextLine();
            if (str.equals("****")) {
                break;
            }
            parseLine(str, map, flag, list);
//            if (i == 0) break;

//            if (str.contains("if")) {
//                System.out.println("str");
//                System.out.println(str);
//                System.out.println("quatationFlag");
//                System.out.println(quatationFlag);
//                System.out.println("cmtFlag");
//                System.out.println(cmtFlag);
//                System.out.println("lineCmtFlag");
//                System.out.println(lineCmtFlag);
//            }

//            if(quatationFlag==1||cmtFlag==1){
////                "  "  第一个 是 1，碰到第二个 变 0，就可以数数
//                continue;
//            }
//            /*

//            注释开始
//            if (str.equals("\"")) {
//                if (quatationFlag == 0) {
//                    quatationFlag = 1;
//                } else {
//                    quatationFlag = 0;
////                    可以
////                    if (map.containsKey(str)) {
////                        map.put(str, map.get(str) + 1);
////                    } else {
////                        map.put(str, 1);
////                    }
//                }
//
//            } else if (str.equals("/*")) {
//                cmtFlag = 1;
////                if (cmtFlag == 0) {
////                    cmtFlag = 1;
////                } else {
////                    cmtFlag = 0;
//////                    可以
//////                    if (map.containsKey(str)) {
//////                        map.put(str, map.get(str) + 1);
//////                    } else {
//////                        map.put(str, 1);
//////                    }
////                }
//            } else if (str.equals("*/")) {
//                cmtFlag = 0;
////                if (cmtFlag == 0) {
////                    cmtFlag = 1;
////                } else {
////                    cmtFlag = 0;
//////                    可以
//////                    if (map.containsKey(str)) {
//////                        map.put(str, map.get(str) + 1);
//////                    } else {
//////                        map.put(str, 1);
//////                    }
////                }
//            } else if (str.equals("//")) {
//                lineCmtFlag = 1;
////            }else if(str.equals("\n")&&lineCmtFlag==1){
//            } else if (str.equals("\n")) {
////                回车不会被作为一个 东西读入
//                lineCmtFlag = 0;
//            }
//
//            if (!list.contains(str)) {
//                continue;
//            }
//            if (cmtFlag == 1 || quatationFlag == 1 || lineCmtFlag == 1) {
//                continue;
//            }
//            if (map.containsKey(str)) {
//                map.put(str, map.get(str) + 1);
//            } else {
//                map.put(str, 1);
//            }
//            注释结束
        }
        System.out.println("map");
        System.out.println(map);
    }
    public static void main(String[] args) {
//        testSub();
//        //");

        cntKeyWords();
    }
}
