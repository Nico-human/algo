package cn.dong.job.exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author dongzhenxun
 * @date 2025/4/12 下午8:58
 * @description 汉得信息笔试
 */
public class Exam0412 {

    // 1
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                Set<Integer> distinctSet = new HashSet<>();
                for (int num : arr) {
                    distinctSet.add(num);
                }
                System.out.println(solution(n, k, distinctSet.size()) ? "Yes": "No");
            }
        }
        private static boolean solution(int n, int k, int uniqueCount) {
            for (int i = 0; i * k <= n; i++) {
                int finalSize = n - i * k;
                if (finalSize <= uniqueCount) {
                    return true;
                }
            }
            return false;
        }
    }

    // 2
    /**
     * SELECT si.shop_type, COUNT(DISTINCT uo.user_id) AS user_count
     * FROM user_order_tb uo
     * JOIN shop_info_tb si ON uo.shop_id = si.shop_id
     * GROUP BY si.shop_type
     * ORDER BY user_count DESC
     * LIMIT 1;
     */

}
