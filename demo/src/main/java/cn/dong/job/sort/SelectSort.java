package cn.dong.job.sort;

import java.util.Arrays;

/**
 * @author dongzhenxun
 * @date 2025/4/23 下午7:42
 * @description 选择排序
 */
public class SelectSort {

    public static void selectSort(int[] arr) {
        int n = arr.length;
        System.out.println("before: " + Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
        System.out.println("after: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        SelectSort.selectSort(new int[]{4, 3, 2, 5, 1});
    }
}
