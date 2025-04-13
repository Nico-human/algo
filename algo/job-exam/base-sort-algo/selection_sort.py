def selection_sort(arr: list) -> list:
    n = len(arr)
    for i in range(n):
        minn = min(range(i, n), key=lambda y: arr[y])
        arr[i], arr[minn] = arr[minn], arr[i]
    return arr

if __name__ == "__main__":
    print(selection_sort([5, 4, 3, 2, 1]))