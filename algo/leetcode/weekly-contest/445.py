
def findClosest(x: int, y: int, z: int) -> int:
    diff = abs(x - z) - abs(y - z)
    if diff < 0:
        return 1
    elif diff > 0:
        return 2
    else:
        return 0

def smallestPalindrome(s: str) -> str:
    n = len(s)
    mid = s[n // 2] if n % 2 == 1 else ""
    s = s[:n // 2]
    cnt = [0] * 26
    for c in s:
        cnt[ord(c) - ord('a')] += 1
    ans = ""
    for i in range(26):
        ans += cnt[i] * chr(ord('a') + i)
    return ans + mid + ans[::-1]