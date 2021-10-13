package lab3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
/*

 */

import java.lang.reflect.Field;
import java.util.*;
import java.util.Map.Entry;


public class CntNum {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            if (i == 0) break;
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        LinkedHashMap<Integer, Integer> integerIntegerLinkedHashMap = MapUtil.sortedMapByValue(map, true);
//        integerIntegerLinkedHashMap.
//        LinkedHashMap 第一个
//        https://blog.csdn.net/weixin_34146986/article/details/92718973

        Map.Entry<Integer, Integer> head = MapUtil.getHead(integerIntegerLinkedHashMap);
        Map.Entry<Integer, Integer> tailByReflection = MapUtil.getTailByReflection(integerIntegerLinkedHashMap);
//        System.out.println("head");
//        System.out.println(head);
        integerIntegerLinkedHashMap.forEach((k, v) -> {
            if (v.equals(head.getValue())) {
//                System.out.println(k+" : "+v+" , ");
//                System.out.println(String.format("数字: %d , 几次 : %d", k, v));
                System.out.println(String.format("Number %d occurred most:%d", k, v));
//                Number 4 occurred most:2
//
            }
        });

//        System.out.println("tailByReflection");
//        System.out.println(tailByReflection);

//        for ()
//        integerIntegerLinkedHashMap.for
    }
}

class Main{
  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
      CntNum.main(args);
  }
}

//1 2 3 4 6 7 8 9 1 2 3 4
//        0
//        map after sort by value asc {6=1, 7=1, 8=1, 9=1, 1=2, 2=2, 3=2, 4=2} ..
//        head
//        6=1
//        tailByReflection
//        4=2

//1 2 3 4 6 7 8 9 1 2 3 4
//        0
//        head
//        1=2
//        tailByReflection
//        9=1


//1 2 3 4 6 7 8 9 1 2 3 4
//        0
//        head
//        1=2
//        数字: 1 , 几次 : 2
//        数字: 2 , 几次 : 2
//        数字: 3 , 几次 : 2
//        数字: 4 , 几次 : 2
//        tailByReflection
//        9=1

