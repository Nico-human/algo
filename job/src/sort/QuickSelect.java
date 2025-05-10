package sort;


import java.util.Random;

/**
 * @author dongzhenxun
 * @date 2025/4/23 下午7:41
 * @description 快速选择排序
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array">快速查找数组中第K个最大的元素</a>
 */
public class QuickSelect {

    public static int quickSelect(int[] arr, int k) {
        return sort(arr, 0, arr.length - 1, arr.length - k);
    }

    private static int sort(int[] arr, int low, int high, int targetIndex) {
        if (low == high) {
            return arr[low];
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

        if (i == targetIndex) {
            return arr[i];
        } else if (i > targetIndex) {
            return sort(arr, low, i - 1, targetIndex);
        } else {
            return sort(arr, i + 1, high, targetIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("第 " + k + " 大的元素是: " + QuickSelect.quickSelect(arr, k));
    }
}
