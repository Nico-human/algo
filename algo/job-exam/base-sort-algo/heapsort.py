
def heapify(arr, n, i):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2

    if left < n and arr[left] > arr[largest]:
        largest = left
    if right < n and arr[right] > arr[largest]:
        largest = right

    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

def heap_sort(arr):
    n = len(arr)

    # 建堆：从最后一个非叶子节点开始，依次堆化整个数组
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)
    # 排序过程：逐步将堆顶元素（最大值）移到数组末尾，并调整剩余部分为最大堆
    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heapify(arr, i, 0)

