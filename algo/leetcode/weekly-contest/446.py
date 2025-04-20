from typing import List

class Solution:
    # Q1: 简单模拟
    def calculateScore(self, instructions: List[str], values: List[int]) -> int:
        n = len(instructions)
        i = 0
        ans = 0
        while 0 <= i < n and values[i] != -100001:
            if instructions[i] == 'add':
                ans += values[i]
                values[i] = -100001
                i += 1
            else:
                before = i
                i += values[i]
                values[before] = -100001
        return ans
    # Q2: 贪心
    def maximumPossibleSize(self, nums: List[int]) -> int:
        ans = 0
        maxx = nums[0]
        n = len(nums)
        for i in range(1, n):
            if nums[i] < maxx:
                ans += 1
            maxx = max(maxx, nums[i])
        return n - ans
    # Q3: DP，最长递增子序列的变种
    def resultArray(self, nums: List[int], k: int) -> List[int]:
        ans = [0] * k
        prev_counts = [0] * k
        for a in nums:
            a_mod = a % k
            current_counts = [0] * k
            for r_prev in range(k):
                if prev_counts[r_prev]:
                    r_new = (r_prev * a_mod) % k
                    current_counts[r_new] += prev_counts[r_prev]
            current_counts[a_mod] += 1
            for r in range(k):
                ans[r] += current_counts[r]
            prev_counts = current_counts.copy()
        return ans
    # 没做
    # def resultArray(self, nums: List[int], k: int, queries: List[List[int]]) -> List[int]: