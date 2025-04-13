
def merge_sort(arr: list) -> list:
    n = len(arr)
    if n <= 1:
        return arr
    arr_left = merge_sort(arr[:n // 2])
    arr_right = merge_sort(arr[n // 2:])
    i, j = 0, 0
    tmp = []
    while i < len(arr_left) and j < len(arr_right):
        if arr_left[i] < arr_right[j]:
            tmp.append(arr_left[i])
            i += 1
        else:
            tmp.append(arr_right[j])
            j += 1
    if i < len(arr_left):
        tmp.extend(arr_left[i:])
    if j < len(arr_right):
        tmp.extend(arr_right[j:])
    return tmp

"""
原地修改
"""
def merge_sort_inplace(arr: list) -> None:
    def merge(start: int, mid: int, end: int) -> None:
        left = arr[start:mid]
        right = arr[mid:end]
        i = j = 0
        k = start

        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                arr[k] = left[i]
                i += 1
            else:
                arr[k] = right[j]
                j += 1
            k += 1

        while i < len(left):
            arr[k] = left[i]
            i += 1
            k += 1
        while j < len(right):
            arr[k] = right[j]
            j += 1
            k += 1

    def merge_sort_recursive(start: int, end: int) -> None:
        if start + 1 < end:
            mid = (start + end) // 2
            merge_sort_recursive(start, mid)
            merge_sort_recursive(mid, end)
            merge(start, mid, end)

    merge_sort_recursive(0, len(arr))

if __name__ == "__main__":
    nums = [4, 3, 3, 2, 1]
    print(merge_sort(nums))