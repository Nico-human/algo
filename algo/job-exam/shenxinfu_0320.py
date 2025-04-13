import sys

def solution1(base: int, exp: int) -> None:
    # 快速幂
    ans = 1
    base = base % 10
    while exp > 0:
        if (exp & 1) == 1:
            ans = (ans * base) % 10
        base = (base * base) % 10
        exp >>= 1
    print(ans)
    return


def solution2(arr1: list, arr2: list) -> None:
    s1 = sum(arr1)
    s2 = sum(arr2)

    diff = s1 - s2
    if diff % 2 != 0:
        print("fail")
        return

    set2 = set(arr2)
    target = diff // 2
    for x in arr1:
        y = x - target
        if y in set2:
            print(x, y)
            return
    return


def solution3() -> None:

    return


if __name__ == '__main__':
    solution1(2, 10)
    solution2([1, 2, 3], [1, 3, 0])