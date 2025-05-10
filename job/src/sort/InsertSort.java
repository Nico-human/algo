package sort;

import java.util.Arrays;

/**
 * @author dongzhenxun
 * @date 2025/4/23 下午7:41
 * @description 插入排序
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        int n = arr.length;
        System.out.println("before: " + Arrays.toString(arr));
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                j--;
            }
        }
        System.out.println("after: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        InsertSort.insertSort(new int[]{3, 2, 4, 5, 1});
    }

}
