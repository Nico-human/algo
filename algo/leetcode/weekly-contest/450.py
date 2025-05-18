from collections import defaultdict, deque
from math import inf
from typing import List


def smallestIndex(nums: List[int]) -> int:
    def calculate(x: int) -> int:
        res = 0
        while x > 0:
            res += x % 10
            x //= 10
        return res

    for i, num in enumerate(nums):
        if calculate(num) == i:
            return i
    return -1

def minSwaps(nums: List[int]) -> int:
    def calculate(x: int) -> int:
        res = 0
        while x > 0:
            res += x % 10
            x //= 10
        return res

    arr = [[calculate(num), num, i] for i, num in enumerate(nums)]
    arr.sort(key=lambda x: (x[0], x[1]))
    n = len(nums)
    visit = [False] * n
    ans = 0
    for i in range(n):
        if visit[i]:
            continue
        cycle, j = 0, i
        while not visit[j]:
            visit[j] = True
            j = arr[j][2]
            cycle += 1
        if cycle > 1:
            ans += cycle - 1
    return ans

def minMoves(matrix: List[str]) -> int:
    DIRS = ((-1, 0), (1, 0), (0, -1), (0, 1))
    m, n = len(matrix), len(matrix[0])
    tpList = defaultdict(list)
    for i in range(m):
        for j in range(n):
            if matrix[i][j] in ('.', '#'):
                continue
            tpList[matrix[i][j]].append((i, j))

    dist = [[inf] * n for _ in range(m)]
    dist[0][0] = 0
    heap = deque([(0, 0)])
    tpGroup = defaultdict(lambda: inf)

    while heap:
        x, y = heap.popleft()
        steps = dist[x][y]
        if x == m - 1 and y == n - 1:
            return steps
        for dx, dy in DIRS:
            nx, ny = x + dx, y + dy
            if 0 <= nx < m and 0 <= ny < n and matrix[nx][ny] != '#':
                nSteps = steps + 1
                if nSteps < dist[nx][ny]:
                    dist[nx][ny] = nSteps
                    heap.append((nx, ny))

        if 'A' <= matrix[x][y] <= 'Z':
            if steps < tpGroup[matrix[x][y]]:
                tpGroup[matrix[x][y]] = steps
                for nx, ny in tpList[matrix[x][y]]:
                    if steps < dist[nx][ny]:
                        dist[nx][ny] = steps
                        heap.appendleft((nx, ny))

    return -1 if dist[m - 1][n - 1] == inf else dist[m - 1][n - 1]

