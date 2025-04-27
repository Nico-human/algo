import collections
from typing import List


def countCoveredBuildings(self, n: int, buildings: List[List[int]]) -> int:
    b = set()
    for x, y in buildings:
        b.add((x, y))
    rows = collections.defaultdict(list)
    cols = collections.defaultdict(list)
    for x, y in b:
        rows[y].append(x)
        cols[x].append(y)
    for y in rows:
        rows[y].sort()
    for x in cols:
        cols[x].sort()
    ans = 0
    for x, y in b:
        row_list = rows[y]
        col_list = cols[x]
        if row_list[0] < x < row_list[-1] and col_list[0] < y < col_list[-1]:
            ans += 1
    return ans

def pathExistenceQueries(self, n: int, nums: List[int], maxDiff: int, queries: List[List[int]]) -> List[bool]:
    dis = [[i, i] for i in range(n)]
    tmp = []
    for i, num in enumerate(nums):
        if tmp and num - tmp[-1][-1] > maxDiff:
            minn, maxx = tmp[0][0], tmp[-1][0]
            for t in tmp:
                dis[t[0]] = [minn, maxx]
            tmp = []
        tmp.append([i, num])

    if tmp:
        minn, maxx = tmp[0][0], tmp[-1][0]
        for t in tmp:
            dis[t[0]] = [minn, maxx]

    m = len(queries)
    ans = [False] * m
    for i, q in enumerate(queries):
        u, v = q[0], q[1]
        if dis[u] == dis[v]:
            ans[i] = True
    return ans