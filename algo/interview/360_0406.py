
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


if __name__ == '__main__':
    print(solution1("10010111001"))