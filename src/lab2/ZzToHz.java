package lab2;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class ZzToHz {

    public static void main(String[] args) {
        new ZzToHz().zzToHz();
    }

    int cmp(String s) {
        //if(s=="(")return 3;
        if (s.equals("*") || s.equals("/")) return 2;
        if (s.equals("+") || s.equals("-")) return 1;
        return 0;
    }

    int compare(String a, String b) {
        if (b.equals(")")) return 1;
        if (a.equals("(") || b.equals("(")) return 0;
        if (b.equals("+") || b.equals("-")) return 1;
        else if (b.equals("*") || b.equals("/")) {
            if (a.equals("+") || a.equals("-")) return 0;
            else if (a.equals("*") || a.equals("/")) return 1;
        }
        return 0;

    }

//    boolean compare(String a,String b)
//    {
//        if(b.equals(")")) return true;
//        if(a.equals("(") || b.equals("(")) return false;
//        if(b.equals("+") || b.equals("-")) return 1;
//        else if(b.equals("*") || b.equals("/")) {
//            if (a.equals("+") || a.equals("-")) return 0;
//            else if (a.equals("*") || a.equals("/")) return 1;
//        }
//        return 0;
//
//    }

//    int can(String a, String b)
//    {
//        return cmp(a)<cmp(b);
//    }

    boolean can(String a, String b) {
        return cmp(a) < cmp(b);
    }

    void zzToHz() {
//        list.add();
//        list.remove()
        Stack<String> st = new Stack<>();
        List<String> ans = new ArrayList<>();
//        stack.peek();
//        stack.pop();
//        stack.add(1);

//        2 + 3 * 4 + 7 / 3 eof
//        2 3 4 * + 7 3 / +
        Scanner scanner = new Scanner(System.in);
//        List<String >words=new ArrayList<>();
        List<String> list = new ArrayList<>();
//        Set<String> words = new TreeSet<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
//            StringUtils.
//            java strip
//            https://www.cnblogs.com/Peter2014/p/12710531.html
            if (word.equals("eof")) {
                break;
            }
            list.add(word);
//            words.add(word.replace('.','1'));
//            words.add(word.replace(".",""));
        }
        for (String ss : list) {
            if (ss.equals("(")) st.push(ss);
            else if (Character.isDigit(ss.charAt(0))) {
//                StrUtil.isNumeric(isdigit(ss.charAt(0))

//                ans.push_back(ss);
                ans.add(ss);
            } else {


                if (ss.equals(")")) {
                    while (!st.peek().equals("(")) {
                        ans.add(st.pop());
//                        st.pop();
                    }
                    st.pop();
                } else {
                    if (st.empty()) st.push(ss);

//                    else if  (can(st.top(),ss))st.push(ss);
                    else if (can(st.peek(), ss)) st.push(ss);
//                ss优先级大  往里面放
                    else {
//  st.top 比ss 大
                        while (!st.empty() && compare(st.peek(), ss) == 1) {
//                        st。top和ss的优先级相同 或者前者大
//                            ans.push_back(st.top());
                            ans.add(st.pop());
//                            st.pop();
//                        比如 st里面有 * 你要放个+ 进去 就要先弹出来 放* 也要先弹出

                        }
                        st.push(ss);
                    }
                }

            }
        }

        while (!st.empty()) {
//            ans.push_back(st.top());
            ans.add(st.pop());
//            st.pop();
        }

        int fir = 1;
//        boolean fir=1;
        for (String an : ans) {
            if (fir == 1) {
//                cout<<an;
                System.out.print(an);
                fir = 0;
            } else {
//                cout<<" "<<an;
                System.out.print(" " + an);
            }
        }

    }
}
