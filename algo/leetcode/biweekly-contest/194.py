# Q1
def peakValleyDifference(self, nums: list[int]) -> int:
	n = len(nums)
	return sum(nums[i] for i in range(1, n - 1) if nums[i] > nums[i - 1] and nums[i] > nums[i + 1]) - \
		sum(nums[i] for i in range(1, n - 1) if nums[i] < nums[i - 1] and nums[i] < nums[i + 1])


# Q2
def countSubarrays(self, nums: list[int], minK: int, maxK: int) -> int:
	ans = 0
	left = 0
	for right, x in enumerate(nums):
		if x < minK or x > maxK:
			left = right + 1
		ans += right - left + 1
	return ans


# Q3
def countMagicalPairs(self, s: str) -> int:
	ans = 0
	n = len(s)
	for j in range(n - 1):
		cntA = [0] * 27
		cntB = [0] * 27
		tmp = set()
		for i in range(j, -1, -1):
			tmp.add(s[i])
			cntA[len(tmp)] += 1
		tmp.clear()
		for k in range(j + 1, n):
			tmp.add(s[k])
			cntB[len(tmp)] += 1
		for a, b in zip(cntA, cntB):
			ans += a * b
	return ans
