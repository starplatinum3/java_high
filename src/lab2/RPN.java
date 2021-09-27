package lab2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RPN {
    //    String []st=new String[11111];
    Integer[] st = new Integer[11111];

    void nibolan() {

//        https://blog.csdn.net/cysqyh/article/details/45696609
//        int fr=0;
        int tp = 0;
        Scanner scanner = new Scanner(System.in);
//        List<String >words=new ArrayList<>();
//        Set<String> words = new TreeSet<>();
        String s = scanner.nextLine();
        scanner.close();
       s=s.replace("+"," +");
       s=s.replace("-"," -");
       s=s.replace("*"," *");
       s=s.replace("/"," /");
//       s=s.replace("+"," +");
//        String[] s1 = s.split(" ");
        String[] s1 = s.split(" ");
//        System.out.println("s1");
//        System.out.println(Arrays.toString(s1));
//        for (String ch : s1) {
//
//        }
        Scanner scannerFromStr=new Scanner(s);
        while (scannerFromStr.hasNext()){
            String next = scannerFromStr.next();
            try{
                Integer integer = Integer.valueOf(next);
                tp++;
                st[tp] = integer;
            }catch (Exception e){
                String  ch=next;
                if (ch.equals("+")) {
                    st[tp - 1] = st[tp - 1] + st[tp];
                    tp--;
//                少了一个 往里面缩进去 所以是 st[tp - 1] =
                } else if (ch.equals("-")) {
                    st[tp - 1] = st[tp - 1] - st[tp];
                    tp--;
                } else if (ch.equals("*")) {
                    st[tp - 1] = st[tp - 1] * st[tp];
                    tp--;
                } else if (ch.equals("/")) {
                    st[tp - 1] = st[tp - 1] / st[tp];
                    tp--;
                }
            }


        }


//        for (int i = 0; i < s.length(); i++) {
////            char ch=s.charAt(i);
//            String  ch=s.charAt(i)+"";
////        }
////        for (String ch : s) {
////            ch=ch.trim();
////            不能 ==  比较字符串，
//            if (ch.equals("+")) {
//                st[tp - 1] = st[tp - 1] + st[tp];
//                tp--;
////                少了一个 往里面缩进去 所以是 st[tp - 1] =
//            } else if (ch.equals("-")) {
//                st[tp - 1] = st[tp - 1] - st[tp];
//                tp--;
//            } else if (ch.equals("*")) {
//                st[tp - 1] = st[tp - 1] * st[tp];
//                tp--;
//            } else if (ch.equals("/")) {
//                st[tp - 1] = st[tp - 1] / st[tp];
//                tp--;
//            } else {
//                if(ch.equals(" "))continue;;
//                tp++;
////                st[tp]=stoi(ch);
//                st[tp] = Integer.parseInt(ch);
//            }
//
//        }

//        s1
//                [31, 11, +, 567, *, 333, -]
//        23481
//        31+11)
        int res = 31 + 11;
        res *= 567;
        res -= 333;
//        System.out.println("res");
//        System.out.println(res);

//        31 11 + 567 * 333 -
//                s1
//                        [31, 11, +, 567, *, 333, -]
//        res
//        23481
//        23481


//        while (scanner.hasNext()) {
//            String ch = scanner.next();
////            st[fr++]=word;
////            if(word=="+"){
////                st[top]=st[top-1]+st[top];
////            }
//
//            if (ch.equals("+")) {
//                st[tp - 1] = st[tp - 1] + st[tp];
//                tp--;
//            } else if (ch == "-") {
//                st[tp - 1] = st[tp - 1] - st[tp];
//                tp--;
//            } else if (ch == "*") {
//                st[tp - 1] = st[tp - 1] * st[tp];
//                tp--;
//            } else if (ch.equals("/")) {
//                st[tp - 1] = st[tp - 1] / st[tp];
//                tp--;
//            } else {
//                tp++;
////                st[tp]=stoi(ch);
//                st[tp] = Integer.parseInt(ch);
//            }
//
//
////            StringUtils.
////            java strip
////            https://www.cnblogs.com/Peter2014/p/12710531.html
////            if(word.equals("eof")){
////                break;
////            }
////            words.add(word.replace('.','1'));
////            words.add(word.replace(".",""));
//        }


        System.out.println(st[1]);
    }

    int test1(String  s,int tp){
        for (int i = 0; i < s.length(); i++) {
//            char ch=s.charAt(i);
            String  ch=s.charAt(i)+"";
//        }
//        for (String ch : s) {
//            ch=ch.trim();
//            不能 ==  比较字符串，
            if (ch.equals("+")) {
                st[tp - 1] = st[tp - 1] + st[tp];
                tp--;
//                少了一个 往里面缩进去 所以是 st[tp - 1] =
            } else if (ch.equals("-")) {
                st[tp - 1] = st[tp - 1] - st[tp];
                tp--;
            } else if (ch.equals("*")) {
                st[tp - 1] = st[tp - 1] * st[tp];
                tp--;
            } else if (ch.equals("/")) {
                st[tp - 1] = st[tp - 1] / st[tp];
                tp--;
            } else {
                if(ch.equals(" "))continue;;
                tp++;
//                st[tp]=stoi(ch);
                st[tp] = Integer.parseInt(ch);
            }

        }
        return tp;

    }
    public static void main(String[] args) {

        new RPN().nibolan();
    }
}

//ac
class Main{
    public static void main(String[] args) {
//        System.out.println("1");
        new RPN().nibolan();
    }
}