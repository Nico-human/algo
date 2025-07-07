package hwod.B200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://blog.csdn.net/banxia_frontend/article/details/147993907
 * 矩阵匹配
 */

public class Main3 {
    static int n, m, k;
    static int[][] matrix;
    static int[] match;
    static boolean[] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        int min = 1, max = Integer.MIN_VALUE;
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
                max = Math.max(max, matrix[i][j]);
            }
        }

        // 二分查找确定第K大的数的最小可能值
        while (min <= max) {
            int mid = (min + max) / 2;
            if (check(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }

    // 检查当前值是否满足条件
    public static boolean check(int currentVal) {
        match = new int[m];
        Arrays.fill(match, -1);
        vis = new boolean[m];
        int smallerCount = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis, false);
            if (dfs(i, currentVal)) {
                smallerCount++;
            }
        }
        return smallerCount >= n - k + 1;
    }

    // 深度优先搜索寻找增广路径
    public static boolean dfs(int i, int currentVal) {
        for (int j = 0; j < m; j++) {
            if (!vis[j] && matrix[i][j] <= currentVal) {
                vis[j] = true;
                if (match[j] == -1 || dfs(match[j], currentVal)) {
                    match[j] = i;
                    return true;
                }
            }
        }
        return false;
    }
}
