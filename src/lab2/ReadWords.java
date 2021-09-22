package lab2;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class ReadWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        List<String >words=new ArrayList<>();
        Set<String> words = new TreeSet<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
//            StringUtils.
//            java strip
//            https://www.cnblogs.com/Peter2014/p/12710531.html
            if(word.equals("eof")){
                break;
            }
//            words.add(word.replace('.','1'));
            words.add(word.replace(".",""));
        }


//
//        Write a program to evaluate postfix expressions. Pass the expression as a commandline argument in one string.
//        eof
//                [Pass, Write, a, argument, as, commandline, evaluate, expression, expressions, in, one, postfix, program, string, the, to]
//
        System.out.println(words);
    }
}
