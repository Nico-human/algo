from collections import defaultdict

# Q1
def minDeletions(self, nums: list[int]) -> int:
    return sum(1 if nums[i] == nums[i + 1] else 0 for i in range(len(nums) - 1))

# Q2
def lastVisitedCell(self, grid: list[list[str]]) -> list[int]:
    m, n = len(grid), len(grid[0])
    visited: set[tuple[int, int]] = set()
    directions = {'U': (-1, 0), 'D': (1, 0), 'L': (0, -1), 'R': (0, 1)}

    def dfs(x: int, y: int) -> tuple[int, int]:
        nx, ny = x + directions[grid[x][y]][0], y + directions[grid[x][y]][1]
        if (nx, ny) in visited or not 0 <= nx < m or not 0 <= ny < n:
            return (x, y)
        visited.add((x, y))
        return dfs(nx, ny)
    return list(dfs(0, 0))

# Q3
def findColoredRoot(self, edges: list[list[int]], colors: str) -> int:
    mapping = ['R', 'B', 'W']
    countart_mapping = {'R': 0, 'B': 1, 'W': 2}
    graph = defaultdict(list[int])
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)

    def dfs(i: int, depth: int) -> bool:
        if i in visited:
            return True
        if colors[i] != mapping[depth]:
            return False
        visited.add(i)

        nex = ''
        for j in graph[i]:
            if j not in visited:
                nex = colors[j]
        if len(nex) == 0:
            return True
        for j in graph[i]:
            if j in visited:
                continue
            if colors[j] != nex:
                return False

        for j in graph[i]:
            if not dfs(j, (depth + 1) % 3):
                return False
        return True

    for k, v in graph.items():
        if len(v) >= 3:
            continue
        visited: set[int] = set()
        if dfs(k, countart_mapping[colors[k]]):
            return k
    return -1