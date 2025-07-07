package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author dongzhenxun
 * @date 2025/6/28 下午4:58
 * @description 观看文艺汇演问题
 */
public class Main10 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        Main10 main = new Main10();
        main.solution(arr, N);
    }

    public void solution(int[][] arr, int N) {
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int maxx = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i][0] >= arr[j][0] + arr[j][1] + 15) {
                    maxx = Math.max(maxx, dp[j]);
                }
            }
            dp[i] = maxx + 1;
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

}
