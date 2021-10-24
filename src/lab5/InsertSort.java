package lab5;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};

        insertSort(arr);

        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    private static void insertSort(int[] arr) {
        //插入排序一次都不能省略
        for (int i = 1; i < arr.length; i++) {
            int key = i - 1;
            int value = arr[i];

            while (key >= 0 && arr[key] > value) {
                arr[key + 1] = arr[key];
                key--;
            }

            arr[key + 1] = value;
        }
    }
}