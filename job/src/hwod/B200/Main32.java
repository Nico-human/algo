package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author dongzhenxun
 * @date 2025/6/29 下午1:26
 * @description 最佳对手 / 实力差距最小总和
 */
public class Main32 {

    public static void main(String[] args) throws IOException {
        Main32 main = new Main32();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = params[0], d = params[1];
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        main.solution(arr, n, d);
    }

    private void solution(int[] arr, int n, int d) {
        Arrays.sort(arr);
        // 下标
        // 不组, 组
        // 匹配的对数, 实力差距的总和
        int[][][] dp = new int[n][2][2];
        dp[0][0] = new int[]{0, 0};
        dp[0][1] = new int[]{0, 0};
        for (int i = 1; i < n; i++) {
            // dp[i][0];
            if (dp[i - 1][0][0] > dp[i - 1][1][0]) {
                dp[i][0] = dp[i - 1][0];
            } else if (dp[i - 1][0][0] < dp[i - 1][1][0]) {
                dp[i][0] = dp[i - 1][1];
            } else {
                dp[i][0] = new int[]{dp[i - 1][0][0], Math.min(dp[i - 1][0][1], dp[i - 1][1][1])};
            }

            // dp[i][1];
            if (arr[i] - arr[i - 1] <= d) {
                dp[i][1] = new int[]{dp[i - 1][0][0] + 1, dp[i - 1][0][1] + arr[i] - arr[i - 1]};
            } else {
                dp[i][1] = dp[i][0];
            }
        }

        int ans = -1;
        if (dp[n - 1][0][0] > dp[n - 1][1][0]) {
            ans = dp[n - 1][0][1];
        } else if (dp[n - 1][0][0] < dp[n - 1][1][0]) {
            ans = dp[n - 1][1][1];
        } else if (dp[n - 1][0][0] == dp[n - 1][1][0] && dp[n - 1][0][0] != 0) {
            ans = Math.min(dp[n - 1][0][1], dp[n - 1][1][1]);
        }

        System.out.println(ans);
    }

}
