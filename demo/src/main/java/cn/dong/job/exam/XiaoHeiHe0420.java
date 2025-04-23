package cn.dong.job.exam;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.PriorityQueue;
/*
 * @author dongzhenxun
 * @date 2025/4/20 下午2:53
 * @description 小黑盒笔试
 */

public class XiaoHeiHe0420 {

    private Set<String> generateAbbreviations(String s) {
        Set<String> abbrs = new HashSet<>();
        int n = s.length();
        if (n < 3) {
            return abbrs;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.charAt(i));
                    sb.append(s.charAt(j));
                    sb.append(s.charAt(k));
                    abbrs.add(sb.toString());
                }
            }
        }
        return abbrs;
    }

    public int calcNames(int N, List<String> names) {
        List<Set<String>> abbrs = new ArrayList<>();
        for (String name : names) {
            abbrs.add(generateAbbreviations(name));
        }

        Set<String> assigned = new HashSet<>();

        for (int i = 0; i < names.size(); i++) {
            Set<String> cityAbbrs = abbrs.get(i);
            boolean foundAssignableAbbr = false;

            for (String abbr : cityAbbrs) {
                boolean isGloballyUnique = true;
                for (int j = 0; j < names.size(); j++) {
                    if (i == j) continue;
                    if (abbrs.get(j).contains(abbr)) {
                        isGloballyUnique = false;
                        break;
                    }
                }

                if (isGloballyUnique) {
                    if (!assigned.contains(abbr)) {
                        assigned.add(abbr);
                        foundAssignableAbbr = true;
                        break;
                    }
                } else {
                    return 0;
                }
            }
        }

        return 1;
    }

    public int calcScheduler(int M, int N, int T) {
        PriorityQueue<Double> hp = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            while (!hp.isEmpty() && hp.peek() <= i) {
                hp.poll();
            }

            if (hp.size() < M) {
                ans++;
                double usage = 0.5 + ((long)i * i) % T;
                double end = i + usage;
                hp.offer(end);
            }
        }
        return ans;
    }

}

/* 实际笔试时 python 代码
import heapq
from itertools import combinations
from typing import List

class Solution:
    def Calc(self, N: int, names: List[str]) -> int:
        def generator(s):
            return set(''.join(c) for c in combinations(s, 3))
        abbrs = [generator(name) for name in names]
        assigned = {}
        for i, city_abbrs in enumerate(abbrs):
            for abbr in city_abbrs:
                if all(abbr not in abbrs[j] for j in range(len(names)) if j != i):
                    if abbr not in assigned:
                        assigned[abbr] = True
                        break
                else:
                    return 0
        return 1

    def Calc(self, M: int, N: int, T: int) -> int:
        hp = []
        ans = 0
        for i in range(N):
            arrival = i
            while hp and hp[0] <= arrival:
                heapq.heappop(hp)
            if len(hp) < M:
                ans += 1
                usage = 0.5 + ((i * i) % T)
                end = arrival + usage
                heapq.heappush(hp, end)
        return ans
 */