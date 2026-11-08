from collections import Counter

# Q1
def findMismatchedSegments(self, s1: str, s2: str) -> list[list[str]]:
	if s1 == s2:
		return []
	left = 0
	n = len(s1)
	ans = []
	for right in range(n):
		if s1[right] != s2[right]:
			continue
		if left < right:
			ans.append([s1[left:right], s2[left:right]])
		left = right + 1
	if left < n:
		ans.append([s1[left:n], s2[left:n]])
	return ans

# Q2
def countSuffix(self, nums: list[int], target: list[int]) -> int:
	if Counter(nums) != Counter(target):
		return 0
	n = len(target)
	suffix = n - 2
	while suffix >= 0 and target[suffix] >= target[suffix + 1]:
		suffix -= 1
	ans = 0
	for i in range(n):
		if i > suffix:
			ans += 1
		if nums[i] != target[i]:
			break
	return ans

# Q3
def minCost(self, n: int, colors: str, edges: list[list[int]]) -> int:
	graph = [[] for _ in range(n)]
	for u, v in edges:
		graph[u].append(v)
		graph[v].append(u)

	fa = [-1] * n
	order = [0]

	for u in order:
		for v in graph[u]:
			if v != fa[u]:
				fa[v] = u
				order.append(v)

	sub_nodes = [1] * n
	dp = [0] * n
	base = best = 0

	for u in reversed(order):
		for v in graph[u]:
			if fa[v] == u:
				sub_nodes[u] += sub_nodes[v]
				dp[u] += max(0, dp[v])
		if colors[u] == "R":
			base += sub_nodes[u]
			dp[u] += sub_nodes[u]
		else:
			dp[u] -= sub_nodes[u]
		best = max(best, dp[u])
	return base - best