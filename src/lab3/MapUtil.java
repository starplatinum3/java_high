package lab3;

import java.lang.reflect.Field;
import java.util.*;
import java.util.Map.Entry;

/**
 * http://lxw1234.com
 * lxw的大数据田地
 * @author lxw1234.com
 * http://lxw1234.com/archives/2015/08/458.htm
 *
 */
public class MapUtil {

    public  static<T> LinkedHashMap<T,Integer> sortedMapByValue(Map<T ,Integer> map){
        return sortedMapByValue(map,false);
        //map按照value升序排序
//        List<Map.Entry<T, Integer>> mapList =
//                new ArrayList<>(map.entrySet());
////        comparingInt reverse
////        ,Comparator.reverseOrder()
//        mapList.sort(Comparator.comparingInt(Map.Entry::getValue));
////        mapList.sort(Comparator.comparing(Map.Entry::getValue).reversed());
////        Non-static method cannot be referenced from a static context
////        mapList.sort(Comparator.comparing(Map.Entry.comparingByValue()).reversed());
////        mapList.sort(Comparator.comparing(Map.Entry::comparingByValue));
//        mapList.sort(Map.Entry.comparingByValue());
////        逆序的排序
////        new Comparable<>()
//        mapList.sort((o1,o2)-> o2.getValue().compareTo(o1.getValue()));
////        Map.Entry.comparingByValue()
////        https://www.cnblogs.com/woyaobianfei/p/9187127.html
//        LinkedHashMap<T,Integer> sortedMapByValue = new LinkedHashMap<>();
//        for (Map.Entry<T, Integer> x : mapList) {
//
//            sortedMapByValue.put(x.getKey(), x.getValue());
//        }
////        System.out.println("map after sort by value asc " + sortedMapByValue + " ..");
//        return sortedMapByValue;
    }

    public  static<T> LinkedHashMap<T,Integer> sortedMapByValue(Map<T ,Integer> map,
                                                                boolean reversed){
        //map按照value升序排序
        List<Map.Entry<T, Integer>> mapList =
                new ArrayList<>(map.entrySet());
//        comparingInt reverse
//        ,Comparator.reverseOrder()
//        mapList.sort(Comparator.comparing(Map.Entry::getValue).reversed());
//        Non-static method cannot be referenced from a static context
//        mapList.sort(Comparator.comparing(Map.Entry.comparingByValue()).reversed());
//        mapList.sort(Comparator.comparing(Map.Entry::comparingByValue));
//        mapList.sort(Map.Entry.comparingByValue());
//        逆序的排序
//        new Comparable<>()
        if(reversed){
            mapList.sort((o1,o2)-> o2.getValue().compareTo(o1.getValue()));

        }else{
            mapList.sort(Comparator.comparingInt(Map.Entry::getValue));

        }
//        Map.Entry.comparingByValue()
//        https://www.cnblogs.com/woyaobianfei/p/9187127.html
        LinkedHashMap<T,Integer> sortedMapByValue = new LinkedHashMap<>();
        for (Map.Entry<T, Integer> x : mapList) {

            sortedMapByValue.put(x.getKey(), x.getValue());
        }
//        System.out.println("map after sort by value asc " + sortedMapByValue + " ..");
        return sortedMapByValue;
    }

//    获取LinkedHashMap中的头部元素（最早添加的元素）：
//
//    时间复杂度O(1)
    public static  <K, V> Map.Entry<K, V> getHead(LinkedHashMap<K, V> map) {
        return map.entrySet().iterator().next();
    }
//    https://blog.csdn.net/weixin_34146986/article/details/92718973

//    获取LinkedHashMap中的末尾元素（最近添加的元素）：
//
//    时间复杂度O(n)
    public static <K, V> Map.Entry<K, V> getTail(LinkedHashMap<K, V> map) {
        Iterator<Entry<K, V>> iterator = map.entrySet().iterator();
        Entry<K, V> tail = null;
        while (iterator.hasNext()) {
            tail = iterator.next();
        }
        return tail;
    }

//    通过反射获取LinkedHashMap中的末尾元素：
//
//    时间复杂度O(1)，访问tail属性
    public  static <K, V> Entry<K, V> getTailByReflection(LinkedHashMap<K, V> map)
            throws NoSuchFieldException, IllegalAccessException {
        Field tail = map.getClass().getDeclaredField("tail");
        tail.setAccessible(true);
        return (Entry<K, V>) tail.get(map);
    }
}
