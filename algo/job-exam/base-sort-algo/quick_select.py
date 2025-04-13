import random

"""
快速查找数组中第K个最大的元素
https://leetcode.cn/problems/kth-largest-element-in-an-array
"""
def quick_select(arr: list, k: int) -> int:
    def sort(low: int, high: int) -> int:
        tmp = random.randint(low, high)
        arr[tmp], arr[low] = arr[low], arr[tmp]
        pivot, i, j = arr[low], low, high
        while i < j:
            while i < j and arr[j] >= pivot:
                j -= 1
            arr[i] = arr[j]
            while i < j and arr[i] <= pivot:
                i += 1
            arr[j] = arr[i]

        arr[i] = pivot

        if i > len(arr) - k:
            return sort(low, i - 1)
        elif i < len(arr) - k:
            return sort(i + 1, high)
        else:
            return arr[i]

    return sort(0, len(arr) - 1)

if __name__ == "__main__":
    print(quick_select([5, 4, 3, 2, 1], 2))