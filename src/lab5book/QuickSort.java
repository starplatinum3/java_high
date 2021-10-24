package lab5book;

//这个是对的
public class QuickSort implements Sort {
  public static void quickSort(int[] list) {
//    两边都是取到的
    quickSort(list, 0, list.length - 1);
  }


  static void swap(int []arr,int i,int j){
    int t=arr[i];
    arr[i]=arr[j];
    arr[j]=t;
  }



  static int Median3(int [] A, int Left, int Right)
  {
    int Center = (Left + Right) / 2;
    if (A[Left] > A[Center]){
//            Collections.swap();
      swap(A,Left,Center);
    }
//            Swap(&A[Left], &A[Center]);
    if (A[Left] > A[Right]){
//            Swap(&A[Left], &A[Right]);
      swap(A,Left,Right);
    }

    if (A[Center] > A[Right]){
//            Swap(&A[Center], &A[Right]);
      swap(A,Center,Right);
    }

    // A[Left] <= A[Center] <= A[Right]
//        Swap(&A[Center], &A[Right - 1]); // 将pivot藏到右边
    swap(A,Center,Right - 1);
    // 如此，子集划分时，便只需考虑A[Left+1]...A[Right]
    return A[Right - 1];
  }

  static   int getPivot(int[] arr, int leftIndex, int rightIndex  ){
//     return    arr[leftIndex];
//    这里的调换 会不会造成数组的问题，这里要复制一份吗？
//    确实，如果不是 clone的，他们的 swap 会造成问题啊
    return   Median3(arr.clone(),  leftIndex,  rightIndex);
  }



  private static void quickSort(int[] list, int first, int last) {
    if (last > first) {
//      两边都是取到的
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }

//  https://blog.csdn.net/weixin_42815609/article/details/102656786

  /** Partition the array list[first..last] */
  private static int partition(int[] list, int first, int last) {
//    int pivot = list[first]; // Choose the first element as the pivot
    int pivot =getPivot(list,first,last);
//    这样子 排序就不正常了
    // Choose the first element as the pivot
    int low = first + 1; // Index for forward search
    int high = last; // Index for backward search

    while (high > low) {
      // Search forward from left
      while (low <= high && list[low] <= pivot)
        low++;

      // Search backward from right
      while (low <= high && list[high] > pivot)
        high--;

      // Swap two elements in the list
      if (high > low) {
        int temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

//    比分割的数 要小的数了，这个 list[high]
//    是吗 到最后
    while (high > first && list[high] >= pivot)
      high--;

    // Swap pivot with list[high]
    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else {
      return first;
    }
  }

  /** A test method */
  public static void main(String[] args) {
    int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    System.out.println("list.length  "+list.length);
    quickSort(list);
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");

//    list.length  10
//            -2 1 2 3 3 6 5 6 14 12
  }

  @Override
  public void sort(int[] list) {
    quickSort(list);
  }
}
