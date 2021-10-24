package lab5book;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HeapSort implements Sort {
  /** Heap sort method */
  public static <E extends Comparable> void heapSort(E[] list) {
    // Create a Heap of integers
    Heap<E> heap = new Heap<E>();

    // Add elements to the heap
    for (int i = 0; i < list.length; i++)
      heap.add(list[i]);

    // Remove elements from the heap
    for (int i = list.length - 1; i >= 0; i--)
      list[i] = heap.remove();
  }
  
  /** A test method */
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    heapSort(list);
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }

  @Override
  public void sort(int[] list) {
//    Arrays.asList(list)
//    List<int[]> ints = Collections.singletonList(list);
//    List<int[]> ints = Collections.as(list);
//    List<Integer>sortLst=new ArrayList<>();
    Integer [] sortLst=new Integer[list.length];
//    int i=0;
    for (int i = 0; i < list.length; i++) {
      sortLst[i]=list[i];
    }
//    for (int i : list) {
//      sortLst.add(i);
//      sortLst[i]
//    }
//    heapSort(Arrays.asList(list));
    heapSort(sortLst);
  }
}
