from collections import Counter


def maxFreqSum(s: str) -> int:
    cnt = Counter(s)
    max_vowel = 0
    for c in 'aeiou':
        max_vowel = max(max_vowel, cnt[c])
        del cnt[c]
    max_consonant = max(cnt.values()) if cnt else 0
    return max_vowel + max_consonant