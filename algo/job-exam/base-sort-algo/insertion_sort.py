
def insertion_sort(arr: list) -> list:
    for i in range(1, len(arr)):
        j = i
        while j > 0 and arr[j - 1] > arr[j]:
            arr[j], arr[j - 1] = arr[j - 1], arr[j]
            j -= 1
    return arr

if __name__ == "__main__":
    print(insertion_sort([5, 1]))