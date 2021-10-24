package lab5;

import lab5book.Sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 快速排序演示
 * https://www.cnblogs.com/luomeng/p/10587492.html
 * @author Lvan
 */
public class QuickSort implements Sort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};

        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + "\t");
        }
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

  static   int getKey(int[] arr, int leftIndex, int rightIndex  ){
//     return    arr[leftIndex];
      return   Median3(arr,  leftIndex,  rightIndex);
    }

    /**
     * @param arr        待排序列
     * @param leftIndex  待排序列起始位置
     * @param rightIndex 待排序列结束位置
     */
    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        //待排序的第一个元素作为基准值
//        int key = arr[left];
        int key = getKey(arr,leftIndex,rightIndex);

        //从左右两边交替扫描，直到left = right
        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }

            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort(arr, leftIndex, left - 1);
        //对基准值右边的元素进行递归排序。
        quickSort(arr, right + 1, rightIndex);
    }

    @Override
    public void sort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }


}