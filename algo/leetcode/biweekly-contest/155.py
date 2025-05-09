import bisect
from collections import defaultdict
from typing import List


def findCommonResponse(responses: List[List[str]]) -> str:
    n = len(responses)
    responses = [set(responses[i]) for i in range(n)]
    cnt = defaultdict(int)

    maxx = 0
    for r in responses:
        for _r in r:
            cnt[_r] += 1
            maxx = max(maxx, cnt[_r])
    ans = [word for word, count in cnt.items() if count == maxx]

    def my_sort(x):
        return x, len(x)
    ans.sort(key=my_sort)
    return ans[0]

def baseUnitConversions(conversions: List[List[int]]) -> List[int]:
    MOD = 1_000_000_000 + 7
    n = len(conversions)
    ans = [1] * (n + 1)
    for con in conversions:
        a, b = con[0], con[1]
        num = con[2]
        ans[b] = num * ans[a] % MOD
    return ans

def countCells(grid: List[List[str]], pattern: str) -> int:
    def compute_failure(p):
        fail = [0] * len_p
        j = 0
        for i in range(1, len_p):
            while j > 0 and p[i] != p[j]:
                j = fail[j - 1]
            if p[i] == p[j]:
                j += 1
            fail[i] = j
        return fail

    def kmp_search(s, p, fail):
        matches = []
        j = 0
        len_s = len(s)
        for i in range(len_s):
            while j > 0 and s[i] != p[j]:
                j = fail[j - 1]
            if s[i] == p[j]:
                j += 1
            if j == len_p:
                matches.append(i - len_p + 1)
                j = fail[j - 1]
        return matches

    m, n = len(grid), len(grid[0])
    len_p = len(pattern)
    flatten_h = ''.join(''.join(row) for row in grid)
    flatten_v = ''.join(''.join(grid[i][j] for i in range(m)) for j in range(n))
    fail = compute_failure(pattern)
    matches_h = kmp_search(flatten_h, pattern, fail)
    matches_v = kmp_search(flatten_v, pattern, fail)

    ans = 0
    for i in range(m):
        for j in range(n):
            pos_h = i * n + j
            a_h = max(0, pos_h - len_p + 1)
            b_h = pos_h
            left = bisect.bisect_left(matches_h, a_h)
            right = bisect.bisect_right(matches_h, b_h)
            has_h = left < right

            pos_v = j * m + i
            a_v = max(0, pos_v - len_p + 1)
            b_v = pos_v
            left_v = bisect.bisect_left(matches_v, a_v)
            right_v = bisect.bisect_right(matches_v, b_v)
            has_v = left_v < right_v
            if has_h and has_v:
                ans += 1
    return ans