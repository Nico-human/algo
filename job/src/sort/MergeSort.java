package sort;

import java.util.Arrays;

/**
 * @author dongzhenxun
 * @date 2025/4/23 下午7:41
 * @description 合并排序
 */
public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return arr;
        }
        int mid = n / 2;
        int[] arrLeft = mergeSort(Arrays.copyOfRange(arr, 0, mid)); // 左半部分
        int[] arrRight = mergeSort(Arrays.copyOfRange(arr, mid, n)); // 右半部分
        return merge(arrLeft, arrRight);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] tmp = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                tmp[k++] = left[i++];
            } else {
                tmp[k++] = right[j++];
            }
        }

        while (i < left.length) {
            tmp[k++] = left[i++];
        }
        while (j < right.length) {
            tmp[k++] = right[j++];
        }
        return tmp;
    }

    // 原地排序
    public static void mergeSortInPlace(int[] arr) {
        mergeSortRecursive(arr, 0, arr.length);
    }

    private static void mergeSortRecursive(int[] arr, int start, int end) {
        if (start + 1 >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortRecursive(arr, start, mid);
        mergeSortRecursive(arr, mid, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] left = Arrays.copyOfRange(arr, start, mid);
        int[] right = Arrays.copyOfRange(arr, mid, end);
        int i = 0, j = 0, k = start;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {

    }

}
