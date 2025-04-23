package cn.dong.job.exam;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
/*
 * @author dongzhenxun
 * @date 2025/3/20 下午2:50
 * @description 深信服笔试
 */

public class ShenXinFu0320 {

    public static void solution1(int base, int exp) {
        int ans = 1;
        base = base % 10;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans = (ans * base) % 10;
            }
            base = (base * base) % 10;
            exp >>= 1;
        }
        System.out.println(ans);
    }

    public static void solution2(List<Integer> arr1, List<Integer> arr2) {
        long s1 = arr1.stream().mapToLong(Integer::longValue).sum();
        long s2 = arr2.stream().mapToLong(Integer::longValue).sum();

        long diff = s1 - s2;
        if (diff % 2 != 0) {
            System.out.println("fail");
            return;
        }

        Set<Integer> set2 = new HashSet<>(arr2);
        long target = diff / 2;

        for (int x : arr1) {
            long y = x - target;
            // Need to cast y back to Integer for set lookup, assuming it fits
            if (y >= Integer.MIN_VALUE && y <= Integer.MAX_VALUE && set2.contains((int) y)) {
                 System.out.println(x + " " + (int) y);
                 return;
            }
        }

        System.out.println("fail");
    }

    public static void solution3() {
        return;
    }

}

/* 实际笔试时 python 代码
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
 */