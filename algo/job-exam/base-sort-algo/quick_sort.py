import random

"""
快排
"""
def quick_sort(arr: list) -> None:
    def sort(low, high):
        if low >= high:
            return
        # 随机选择枢轴
        tmp = random.randint(low, high)
        arr[low], arr[tmp] = arr[tmp], arr[low]

        pivot, i, j = arr[low], low, high
        while i < j:
            while i < j and arr[j] >= pivot:
                j -= 1
            arr[i] = arr[j]
            while i < j and arr[i] <= pivot:
                i += 1
            arr[j] = arr[i]
        arr[i] = pivot
        sort(low, i - 1)
        sort(i + 1, high)

    sort(0, len(arr) - 1)

if __name__ == '__main__':
    num = [5, 4, 3, 2, 1]
    quick_sort(num)