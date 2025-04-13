from typing import List


def minOperations(nums: List[int], k: int) -> int:
    return sum(nums) % k

def uniqueXorTriplets(nums: List[int]) -> int:
    n = len(nums)
    if n <= 2:
        return n
    m = 1
    while m <= n:
        m <<= 1
    return m
