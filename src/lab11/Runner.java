package lab11;

import java.util.Arrays;
import java.util.Comparator;

public class Runner implements Runnable {
    Integer people[];
//两副牌
//    https://jingyan.baidu.com/article/425e69e69ee6f8be14fc1660.html
    @Override
    public void run() {
        int i, j;
        // TODO 自动生成的方法存根
        Arrays.sort(people, new Comparator<Integer>() {
            @Override
            public int compare(Integer b, Integer a) {
                if (a == 16 || a == 68) {
                    return 1;
                } else if (b == 16 || b == 68) {
                    return -1;
                } else if (a == 106 || a == 107) {
                    return a - b;
                } else if (b == 106 || b == 107) {
                    return -1;
                } else if (a == 104 || a == 105) {
                    return a - b;
                } else if (b == 104 || b == 105) {
                    return -1;
                } else if (a == 40 || a == 92) {
                    return 1;
                } else if (b == 40 || b == 92) {
                    return -1;
                } else if (a == 1 || a == 53) {
                    return 1;
                } else if (b == 1 || b == 53) {
                    return -1;
                } else if (a == 39 || a == 91) {
                    return 1;
                } else if (b == 39 || b == 91) {
                    return -1;
                } else if (a % 13 == 0) {
                    return 1;
                } else if (b % 13 == 0) {
                    return -1;
                } else if ((a / 13) % 4 == 3 && (b / 13) % 4 != 3) {
                    return 1;
                } else if ((b / 13) % 4 == 3 && (a / 13) % 4 != 3) {
                    return -1;
                } else if (a > 51 && b > 51) {
                    return a - b;
                } else if (a > 51 && b < 51) {
                    return (a - 52) - b;
                } else if (a < 51 && b > 51) {
                    return a - (b - 52);
                } else {
                    return a - b;
                }
            }
        });
        String s = "我的牌是:";

        for (i = 0; i < people.length; i++) {
            if (people[i] == 107 || people[i] == 106)
                s += "大王";
            else if (people[i] == 104 || people[i] == 105)
                s += "小王";
            else {
                if ((people[i] / 13) % 4 == 0) {
                    s += "梅花";
                } else if ((people[i] / 13) % 4 == 1) {
                    s += "红心";
                } else if ((people[i] / 13) % 4 == 2) {
                    s += "方块";
                } else if ((people[i] / 13) % 4 == 3) {
                    s += "黑桃";
                }

                if (people[i] % 13 == 12)
                    s += "A";
                else if (people[i] % 13 == 9)
                    s += "J";
                else if (people[i] % 13 == 10)
                    s += "Q";
                else if (people[i] % 13 == 11)
                    s += "K";
                else
                    s += (people[i] % 13 + 2);

            }
            if (i != 24)
                s += " ,";
        }

        System.out.println(s);

    }

    public Runner(Integer[] p) {
        this.people = p;
    }

}
