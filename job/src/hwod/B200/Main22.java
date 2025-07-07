package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author dongzhenxun
 * @date 2025/6/29 上午11:39
 * @description 返回矩阵中非1的元素、个数/数值同化
 */
public class Main22 {

    private int ans;

    public static void main(String[] args) throws IOException {
        Main22 main = new Main22();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = params[0], n = params[1];
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            grid[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        main.ans = m * n;
        main.solution(grid);
    }

    private void solution(int[][] grid) {
        final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = grid.length, n = grid[0].length;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0});
        ans--;
        grid[0][0] = 1;

        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = dq.poll();
                int x = tmp[0], y = tmp[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + DIRS[j][0], ny = y + DIRS[j][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 0) {
                        continue;
                    }
                    ans--;
                    grid[nx][ny] = 1;
                    dq.offer(new int[]{nx, ny});
                }
            }
        }

        System.out.println(ans);
    }


}
