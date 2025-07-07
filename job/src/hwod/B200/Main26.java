package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dongzhenxun
 * @date 2025/6/29 下午12:25
 * @description 最小矩阵宽度
 */
public class Main26 {

    public static void main(String[] args) throws IOException {
        Main26 main = new Main26();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = params[0], m = params[1];
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int k = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        main.solution(grid, arr);
    }

    public void solution(int[][] grid, int[] arr) {
        int m = grid.length, n = grid[0].length;
        int k = arr.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x: arr) {
            cnt.merge(x, 1, Integer::sum);
        }
        int diff = cnt.size();
        int left = 0, ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            for (int i = 0; i < m; i++) {
                int x = grid[i][right];
                if (cnt.containsKey(x)) {
                    cnt.merge(x, -1, Integer::sum);
                    if (cnt.get(x) == 0) {
                        diff--;
                    }
                }
            }
            while (left <= right && diff == 0) {
                ans = Math.min(ans, right - left + 1);
                for (int i = 0; i < m; i++) {
                    int x = grid[i][left];
                    if (cnt.containsKey(x)) {
                        if (cnt.get(x) == 0) {
                            diff++;
                        }
                        cnt.merge(x, 1, Integer::sum);
                    }
                }
                left++;
            }
        }
        System.out.println((ans == Integer.MAX_VALUE) ? -1: ans);
    }

}
