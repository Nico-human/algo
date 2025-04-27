from typing import List


# 在文本串 text 中查找模式串 pattern，返回所有成功匹配的位置（pattern[0] 在 text 中的下标）
def kmp(text: str, pattern: str) -> List[int]:
    m = len(pattern)
    pi = [0] * m
    cnt = 0
    for i in range(1, m):
        b = pattern[i]
        while cnt and pattern[cnt] != b:
            cnt = pi[cnt - 1]
        if pattern[cnt] == b:
            cnt += 1
        pi[i] = cnt

    pos = []
    cnt = 0
    for i, b in enumerate(text):
        while cnt and pattern[cnt] != b:
            cnt = pi[cnt - 1]
        if pattern[cnt] == b:
            cnt += 1
        if cnt == len(pattern):
            pos.append(i - m + 1)
            cnt = pi[cnt - 1]
    return pos

if __name__ == '__main__':
    idx = kmp('ababa', 'aba')
    print(idx)
