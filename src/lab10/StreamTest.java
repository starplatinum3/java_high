package lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();
        int [] a=new int[]{1,22,33,44,421,4,5,6,4,32,3,53,45,32,3421,5};
        for (int i : a) {
            list.add(i);
        }
//        list.stream().filter(o->o.compareTo(10)>0)
        List<Integer> collectBigger10 = list.stream().filter(o -> o > 10).collect(Collectors.toList());
        System.out.println("collectBigger10");
        System.out.println(collectBigger10);
        Double collectBigger10Avg = collectBigger10.stream().mapToInt(Integer::intValue).average().orElse(0D);
        System.out.println("collectBigger10Avg");
        System.out.println(collectBigger10Avg);
//        stream 求和
//        Double min = list.stream().min(Double::compareTo).get();
        Integer min = list.stream().filter(o -> o > 20).min(Integer::compareTo).get();
        System.out.println("min");
        System.out.println(min);
//        collectBigger10
//                [22, 33, 44, 421, 32, 53, 45, 32, 3421]
//        collectBigger10Avg
//        455.8888888888889
//        min
//        22


    }
}
