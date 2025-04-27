from typing import List

# 计算pi数组，pi[i] 表示0～i位置的字符串的最大匹配长度
def calcu_pi(pattern: str) -> List[int]:
    n = len(pattern)
    pi = [0] * n
    cnt = 0
    for i in range(1, n):
        b = pattern[i]
        while cnt > 0 and pattern[cnt] != b:
            cnt = pi[cnt - 1]
        if pattern[cnt] == b:
            cnt += 1
        pi[i] = cnt
    return pi


# 在文本串 text 中查找模式串 pattern，返回所有成功匹配的位置（pattern[0] 在 text 中的下标）
def kmp_search(text: str, pattern: str, pi: List[int]) -> List[int]:
    n, m = len(text), len(pattern)
    pos = []
    cnt = 0
    for i, b in enumerate(text):
        while cnt > 0 and pattern[cnt] != b:
            cnt = pi[cnt - 1]
        if pattern[cnt] == b:
            cnt += 1
        if cnt == m:
            pos.append(i - m + 1)
            cnt = pi[cnt - 1]
    return pos

if __name__ == '__main__':
    pi = calcu_pi('ababa')
    idx = kmp_search('ababa', 'aba', pi)
    print(idx)
