package lab5book;

public class QuickSortMedian3 {

    public static void main(String[] args) {
        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};

//        new QuickSortMedian3().Quciksort(arr,0,arr.length - 1);
//        Quicksort(arr, 0, arr.length - 1);

        new QuickSortMedian3().   Qsort(arr,0,arr.length - 1);
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

//
//    ElementType Median3(ElementType A[], int Left, int Right)
//    {
//        int Center = (Left + Right) / 2;
//        if (A[Left] > A[Center])
//            Swap(&A[Left], &A[Center]);
//        if (A[Left] > A[Right])
//            Swap(&A[Left], &A[Right]);
//        if (A[Center] > A[Right])
//            Swap(&A[Center], &A[Right]);
//        // A[Left] <= A[Center] <= A[Right]
//        Swap(&A[Center], &A[Right - 1]); // 将pivot藏到右边
//        // 如此，子集划分时，便只需考虑A[Left+1]...A[Right]
//        return A[Right - 1];
//    }


    void Quick_Sort(int A[], int N)
    {
        Quciksort(A, 0, N - 1);
    }




    void Qsort(int A[], int Left, int Right) { /* 核心递归函数 */
        int Pivot, Cutoff, Low, High;
//        Cutoff = 22;
            Pivot = Median3(A, Left, Right); /* 选基准 */
            Low = Left;
            High = Right - 1;
            while (true) { /*将序列中比基准小的移到基准左边，大的移到右边*/
                while (A[++Low] < Pivot);
                while (A[--High] > Pivot);
                if (Low < High){
                    swap(A,Low,High);
//                    Swap(&A[Low], &A[High]);
                }
            else break;
            }
            swap(A,Low,Right-1);
//            Swap(&A[Low], &A[Right - 1]);   /* 将基准换到正确的位置 */
            Qsort(A, Left, Low - 1);    /* 递归解决左边 */
            Qsort(A, Low + 1, Right);   /* 递归解决右边 */
    }

    void Quciksort(int A[], int Left, int Right)
    {
        int i,j;

           int Pivot = Median3(A, Left, Right);
            i = Left;
            j = Right;
            for (;;)
            {
                while (A[++i] < Pivot)
                {
                }
                while (A[--j] > Pivot)
                {
                }
                if (i < j){
                    swap(A,i,j);
                }
//                    Swap(&A[i], &A[j]);
            else
                break;
            }
            swap(A,i,Right-1);
//            Swap(&A[i], &A[Right - 1]);
            Quciksort(A, Left, i - 1);
            Quciksort(A, i + 1, Right);

    }

}
