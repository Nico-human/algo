import math


# 判断是否是质数, O(sqrt(n))
def is_prime(x: int) -> bool:
	for i in range(2, math.isqrt(x) + 1):
		if x % i == 0:
			return False
	return x >= 2

# 质数筛(埃氏筛)
def preprocess_prime():
	MX = 1_000_001
	is_prime = [False] * 2 + [True] * (MX - 2) # 0，1不是质数
	primes = []
	for i in range(2, MX):
		if is_prime[i]:
			primes.append(i)
			for j in range(i * i, MX, i):
				is_prime[j] = False # j 是质数 i 的倍数

# gcd, 最大公约数
def gcd(x: int, y: int) -> int:
	return math.gcd(x, y)

# lcm，最小公倍数
def lcm(x: int, y: int) -> int:
	return math.lcm(x, y)