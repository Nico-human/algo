from collections import deque


# Q1
def countValidSubstrings(self, s: str) -> int:
	ans = 0
	left = 0
	for right, c in enumerate(s):
		while right - left >= 2 and s[right - 2: right + 1] == 'abc':
			left = right - 1
		ans += right - left + 1
	return ans

# Q2
def canRemoveAll(self, types: list[int], colors: list[int], groupSize: list[int]) -> bool:
	st = []
	n, m = len(types), len(groupSize)
	for i in range(n):
		type, color = types[i], colors[i]
		cnt = 1
		if st and st[-1][0] == type and st[-1][1] == color:
			cnt = st[-1][2] + 1
		st.append((type, color, cnt))
		if cnt == groupSize[type]:
			for _ in range(cnt):
				st.pop()
	return len(st) == 0

# Q3
def countValidSubstrings(self, s: str) -> int:
	abc = {'a': deque(), 'b': deque(), 'c': deque()}
	ans = left = 0
	for right, c in enumerate(s):
		abc[c].append(right)
		while c == 'c' and abc['a'] and abc['b'] and abc['a'][0] < abc['b'][-1]:
			abc[s[left]].popleft()
			left += 1
		ans += right - left + 1
	return ans

# Q4
def repeatedStringMatch(self, a: str, b: str, x: int, y: int) -> bool:
	m, n = len(a), len(b)
	if y * n > x * m:
		return False
	minn = min(n * y, m + n)
	sub = (b * ((minn + n - 1) // n))[:minn]
	t = a * ((minn + m - 1) // m + 1)
	left = t.find(sub)
	return left != -1 and left + n * y <= m * x