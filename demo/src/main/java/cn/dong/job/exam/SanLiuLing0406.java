package cn.dong.job.exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * @author dongzhenxun
 * @date 2025/4/6 下午2:42
 * @description 360笔试
 */

public class SanLiuLing0406 {

    public static String solution1(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        char[] suffixMin = new char[n];
        suffixMin[n - 1] = chars[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = (chars[i] < suffixMin[i + 1]) ? chars[i] : suffixMin[i + 1];
        }

        int i = 0;
        boolean iFound = false;
        for (; i < n - 1; i++) {
            if (chars[i] > suffixMin[i + 1]) {
                iFound = true;
                break;
            }
        }

        if (!iFound) {
            return s;
        }

        char target = suffixMin[i + 1];
        String minString = s;

        for (int j = i + 1; j < n; j++) {
            if (chars[j] == target) {
                StringBuilder candidateBuilder = new StringBuilder();
                candidateBuilder.append(s.substring(0, i));
                for (int k = j; k >= i; k--) {
                    candidateBuilder.append(chars[k]);
                }
                candidateBuilder.append(s.substring(j + 1));
                String candidate = candidateBuilder.toString();
                if (candidate.compareTo(minString) < 0) {
                    minString = candidate;
                }
            }
        }
        return minString;
    }

    private static final Pattern INVALID_TOKEN_PATTERN = Pattern.compile("(?<!\\d)0\\d+");

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt();
        scanner.nextLine();

        for (int k = 0; k < numTestCases; k++) {
            String eq = scanner.nextLine().trim();
            long equalsCount = eq.chars().filter(ch -> ch == '=').count();
            if (equalsCount != 1) {
                System.out.println("No");
                continue;
            }
            if (checkEq(eq)) {
                System.out.println("Yes");
                continue;
            }
            boolean found = false;
            int n = eq.length();

            for (int i = 0; i <= n; i++) {
                for (char d : "0123456789".toCharArray()) {
                    String newEq = eq.substring(0, i) + d + eq.substring(i);
                    if (checkEq(newEq)) {
                        System.out.println("Yes");
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }

            if (!found) {
                System.out.println("No");
            }
        }
        scanner.close();
    }

    private static boolean validTokens(String e) {
        Matcher matcher = INVALID_TOKEN_PATTERN.matcher(e);
        return !matcher.find();
    }

    private static long evalExpr(String e) {
        long totalSum = 0;
        String[] addParts = e.split("\\+");

        for (String addPart : addParts) {
            long currentProduct = 1;
            String[] multParts = addPart.split("\\*");

            for (String multPart : multParts) {
                long number = Long.parseLong(multPart.trim());
                currentProduct *= number;
            }
            totalSum += currentProduct;
        }
        return totalSum;
    }

    private static boolean checkEq(String eq) {
        String[] parts = eq.split("=");

        if (parts.length != 2) {
            return false;
        }

        String L = parts[0].trim();
        String R = parts[1].trim();

        if (!validTokens(L) || !validTokens(R)) {
            return false;
        }

        try {
            long leftValue = evalExpr(L);
            long rightValue = evalExpr(R);
            return leftValue == rightValue;
        } catch (NumberFormatException | ArithmeticException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Solution 1 for \"10010111001\": " + solution1("10010111001"));
        // solution2();
    }
}

/* 实际笔试时 python 代码
def solution1(s: str) -> str:
    n = len(s)
    chars = list(s)

    # 预处理：suffix_min[i] 表示 s[i:] 中的最小字符
    suffix_min = [''] * n
    suffix_min[-1] = chars[-1]
    for i in range(n - 2, -1, -1):
        suffix_min[i] = chars[i] if chars[i] < suffix_min[i + 1] else suffix_min[i + 1]
    # 寻找第一个满足 chars[i] > suffix_min[i+1] 的位置
    for i in range(n - 1):
        if chars[i] > suffix_min[i + 1]:
            break
    else:
        return s

    target = suffix_min[i + 1]
    min_string = s
    for j in range(i + 1, n):
        if chars[j] == target:
            candidate = ''.join(chars[:i] + chars[i:j + 1][::-1] + chars[j + 1:])
            if candidate < min_string:
                min_string = candidate
    return min_string


def solution2():
    import re
    from math import prod
    vt = re.compile(r'(?<!\d)0\d+')
    def valid_tokens(e):
        return vt.search(e) is None
    def eval_expr(e):
        return sum(prod(map(int, s.split('*'))) for s in e.split('+'))
    def check_eq(eq):
        L, sep, R = eq.partition('=')
        if sep != '=': return False
        if not valid_tokens(L) or not valid_tokens(R): return False
        try:
            return eval_expr(L) == eval_expr(R)
        except:
            return False

    for _ in range(int(input())):
        eq = input().strip()
        if eq.count('=') != 1:
            print("No")
            continue
        if check_eq(eq):
            print("Yes")
            continue
        found = False
        n = len(eq)
        for i in range(n + 1):
            for d in "0123456789":
                new_eq = eq[:i] + d + eq[i:]
                L, sep, R = new_eq.partition('=')
                if sep != '=': continue
                if not valid_tokens(L) or not valid_tokens(R): continue
                try:
                    if eval_expr(L) == eval_expr(R):
                        print("Yes")
                        found = True
                        break
                except:
                    continue
            if found: break
        if not found:
            print("No")
*/