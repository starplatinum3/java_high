package lab5book;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTest {
//    1、编写一个程序，
//    获取输入规模为50000、100000、150000、200000、250000、300000时的
//    选择排序、冒泡排序、归并排序、快速排序、堆排序以及基数排序的执行时间。
//    该程序应随机的创建数据，然后打印如下表格：

    int[] genLst(int size) {
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
//            list[i] = (int) RedPackageUtil.random(-999999999, 999999999);
            list[i] = (int) RedPackageUtil.random(0, 999999999);
        }
        return list;
    }

    void testOneBatch(int size) {
//        int[] list=new int[size];
//        int[] sortLst=new int[size];
//        for (int i = 0; i < size; i++) {
//            list[i]=(int)RedPackageUtil.random(-999999999,999999999);
//        }
//        sortLst=  list.clone();
//        BubbleSort.bubbleSort(list);
//        out += size + ",";
        out.append( size).append(",") ;
        int[] list = genLst(size);
        for (Sort sort : sorts) {
            long startTime = System.currentTimeMillis();
            int [] sortLst=  list.clone();
            sort.sort(sortLst);
//            sort.sort(list);
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            System.out.println(executionTime);
//            out+=size+","+
//            out += executionTime + "ms,";
            out.append( executionTime).append("ms,") ;
        }
//        out += "\n";
        out.append("\n");
    }

    List<Sort> sorts = new ArrayList<>();

//    String out = "数组大小,选择排序,冒泡,归并,快速,堆,基数\n";
    StringBuilder out= new StringBuilder("数组大小,选择排序,冒泡,归并,快速,堆,基数\n");
//    https://blog.csdn.net/qq_21769133/article/details/72844008

     void testQuick(){
//        int[] ints = genLst(500000);
        int[] ints = genLst(50000000);
//        QuickSort.quickSort(ints);
//       new  QuickSort().sort(ints);
//        这样是可以的
         Arrays.sort(ints);

    }
    void test() {
//        数组大小	选择排序	冒泡	归并	快速	堆	基数


        int[] sizeLst = new int[]{50000, 100000, 150000, 200000, 250000, 300000};

        sorts.add(new SelectionSort());
        sorts.add(new BubbleSort());
        sorts.add(new MergeSort());
//        sorts.add(new QuickSort());
        sorts.add(new lab5. QuickSort());
        sorts.add(new HeapSort());
//        sorts.add(new RadixSort());
        sorts.add(new RadixSortNegative());
//        for (Sort sort : sorts) {
//            sort.sort();
//        }

//        testOneBatch(sizeLst[0]);


        for (int size : sizeLst) {
            System.out.println("size: "+size);
            testOneBatch(size);
//            int[] list=new int[size];
//            int[] sortLst=new int[size];
//            for (int i = 0; i < size; i++) {
//                list[i]=(int)RedPackageUtil.random(-999999999,999999999);
//            }
//            sortLst=  list.clone();
//            BubbleSort.bubbleSort(list);


        }
//
//
        String  outFileName="sort.csv";
        try (FileWriter fileWriter = new FileWriter(outFileName)) {
//            fileWriter.write(out);
            fileWriter.write(String.valueOf(out));
            System.out.println("write here  "+outFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    void testQuickTime(){

        long startTime = System.currentTimeMillis();
//        sort.sort(list);

        new SortTest().testQuick();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("executionTime "+executionTime);
//        executionTime 13772
//        需要这么久吗
//        executionTime 9803
//        确实 ，jdk的算法也要这么久
    }

    public static void main(String[] args) {

//        System.out.println("1\t1");
//        不能直接复制到 excel 作为表格
        new SortTest().test();


    }
}
