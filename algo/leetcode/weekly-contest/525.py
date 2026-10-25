# Q1
def calculateScore(self, a: int, b: int) -> int:
	s1, s2 = a.bit_count(), b.bit_count()
	return s1 * s2 if s1 >= s2 else s2 // s1


# Q2
def maximizeSum(self, nums: list[int], k: int) -> int:
	def adjust(x: int) -> int:
		s = list(str(x))
		s.sort(reverse=True)
		return int(''.join(s))

	ads = [adjust(x) - x for x in nums]
	ads.sort(reverse=True)
	ans = sum(nums)
	for _, x in enumerate(ads):
		if x <= 0 or k <= 0:
			break
		ans += x
		k -= 1
	return ans


# Q3
def countStaircase(self, nums: list[int]) -> int:
	n = len(nums)
	ans = 0
	for left in range(n):
		mp = {}
		end = 0
		k = n - left
		for right in range(left, n):
			x = nums[right]
			v = mp.get(x, -1)
			if v == -1:
				m = len(mp) + 1
				end += m
				if end > k:
					break
				mp[x] = m - 1
			else:
				if v == 0:
					break
				mp[x] = v - 1
			if right - left + 1 == end:
				ans += 1
	return ans
