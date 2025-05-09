package cn.dong.job.interview;
import java.util.*;
import java.io.*;

/**
 * @author dongzhenxun
 * @date 2025/5/9 下午10:53
 * @description 用友笔试0509
 */
public class YonYou0509 {

    class Solution01 {
         /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * @param songs int整型一维数组 歌曲编号数组
         * @param k int整型 最常听的歌曲数目
         * @return int整型一维数组
         */
        public int[] favoriteSongs(int[] songs, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int song: songs) {
                map.merge(song, 1, Integer::sum);
            }
            List<Map.Entry<Integer, Integer>> freq = new ArrayList<>(map.entrySet());
            Collections.sort(freq, (a, b) -> b.getValue() - a.getValue());

            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = freq.get(i).getKey();
            }
            Arrays.sort(ans);

            return ans;
        }
    }

    class Solution02 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[] capacity = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                capacity[i] = Integer.parseInt(st.nextToken());
            }

            int[][] meeting = new int[n][3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                meeting[i][0] = Integer.parseInt(st.nextToken());
                meeting[i][1] = Integer.parseInt(st.nextToken());
                meeting[i][2] = Integer.parseInt(st.nextToken());
            }
            boolean ans = solution(m, n, capacity, meeting);
            System.out.println(ans);
        }

        public static boolean solution(int m, int n, int[] capacity, int[][] meeting) {
            Arrays.sort(meeting, (a, b) -> a[0] - b[0]);
            PriorityQueue<int[]> room = new PriorityQueue<>((a, b) -> a[0] - b[0]);

            for (int i = 0; i < m; i++) {
                room.offer(new int[]{0, i});
            }

            for (int[] mt: meeting) {
                int start = mt[0];
                int end = mt[1];
                int people = mt[2];

                List<int[]> available = new ArrayList<>();
                while (!room.isEmpty() && room.peek()[0] <= start) {
                    available.add(room.poll());
                }

                int bestIdx = -1;
                int minCapa = Integer.MAX_VALUE;
                for (int i = 0; i < available.size(); i++) {
                    int roomIdx = available.get(i)[1];
                    if (capacity[roomIdx] >= people && capacity[roomIdx] < minCapa) {
                        minCapa = capacity[roomIdx];
                        bestIdx = i;
                    }
                }
                if (bestIdx == -1) {
                    return false;
                }
                int[] select = available.remove(bestIdx);
                room.offer(new int[]{end, select[1]});
                for (int[] t: available) {
                    room.offer(t);
                }
            }

            return true;
        }
    }

    /**
     * <a href="https://leetcode.cn/problems/stone-game/description/">877. 石子游戏 的变种</a>
     */
    class Solution03 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean ans = solution(n, arr);
            System.out.println(ans);
            // System.out.println(n % 2 == 0);
        }

        public static boolean solution(int n, int[] arr) {
            if (n % 2 == 0) {
                return true;
            } else {
                return false;
            }
        }
    }


    static class Solution04 {
        class Item {
            int start;
            int duration;
            int profit;
            int end;

            public Item(int start, int duration, int profit) {
                this.start = start;
                this.duration = duration;
                this.profit = profit;
                this.end = start + duration;
            }
        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] startTime = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                startTime[i] = Integer.parseInt(st.nextToken());
            }

            int[] duration = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                duration[i] = Integer.parseInt(st.nextToken());
            }

            int[] profit = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                profit[i] = Integer.parseInt(st.nextToken());
            }

            int ans = new Solution04().solution(n, startTime, duration, profit);
            System.out.println(ans);
        }

        public int solution(int n, int[] startTime, int[] duration, int[] profit) {
            List<Item> items = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                items.add(new Item(startTime[i], duration[i], profit[i]));
            }
            items.sort((a, b) -> a.end - b.end);

            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                int currStart = items.get(i).start;
                int currProfit = items.get(i).profit;
                int j = findMaxJ(items, i);
                int currBenefit = (j == -1) ? currProfit : dp[j] + currProfit;
                if (i == 0) {
                    dp[i] = currBenefit;
                } else {
                    dp[i] = Math.max(dp[i - 1], currBenefit);
                }
            }
            return dp[n - 1];
        }

        public int findMaxJ(List<Item> list, int i) {
            int target = list.get(i).start;
            int left = 0;
            int right = i - 1;
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid).end <= target) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }
    }

}
