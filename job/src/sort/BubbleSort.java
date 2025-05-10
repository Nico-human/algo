package sort;

import java.util.Arrays;

/**
 * @author dongzhenxun
 * @date 2025/4/23 下午7:40
 * @description 冒泡排序
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        System.out.println("before: " + Arrays.toString(arr));
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("after: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        BubbleSort.bubbleSort(new int[]{2, 3, 1, 4, 2});
    }

}
