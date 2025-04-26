import heapq
from itertools import combinations
from typing import List


class Solution:
    def Calc(self, N: int, names: List[str]) -> int:
        def generator(s):
            return set(''.join(c) for c in combinations(s, 3))
        abbrs = [generator(name) for name in names]
        assigned = {}
        for i, city_abbrs in enumerate(abbrs):
            for abbr in city_abbrs:
                if all(abbr not in abbrs[j] for j in range(len(names)) if j != i):
                    if abbr not in assigned:
                        assigned[abbr] = True
                        break
                else:
                    return 0
        return 1

    def Calc(self, M: int, N: int, T: int) -> int:
        hp = []
        ans = 0
        for i in range(N):
            arrival = i
            while hp and hp[0] <= arrival:
                heapq.heappop(hp)
            if len(hp) < M:
                ans += 1
                usage = 0.5 + ((i * i) % T)
                end = arrival + usage
                heapq.heappush(hp, end)
        return ans
