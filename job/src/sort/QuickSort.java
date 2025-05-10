package sort;

import java.util.Random;

/**
 * @author dongzhenxun
 * @date 2025/4/23 下午7:42
 * @description 快排
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        Random random = new Random();
        int pivotIndex = low + random.nextInt(high - low + 1);
        int tmp = arr[pivotIndex];
        arr[pivotIndex] = arr[low];
        arr[low] = tmp;

        int pivot = arr[low];
        int i = low, j = high;
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        sort(arr, low, i - 1);
        sort(arr, i + 1, high);
    }

    public static void main(String[] args) {

    }

}
