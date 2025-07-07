package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author dongzhenxun
 * @date 2025/6/28 下午6:29
 * @description 亲子游戏
 */
public class Main14 {

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int ans;
    private int ansStep;
    private int[][] grid;
    private boolean[][] vis;
    private int n;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Main14 main = new Main14();
        main.solution(grid);
    }

    public void solution(int[][] grid) {
        int n = grid.length;
        this.n = n;
        ansStep = n * n + 1;
        ans = Integer.MIN_VALUE;

        this.vis = new boolean[n][n];
        this.grid = grid;
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -3) {
                    dfs(i, j, 0, 0);
                    break;
                }
            }
        }

        if (ans == Integer.MIN_VALUE) {
            ans = -1;
        }
        System.out.println(ans);
    }

    public void dfs(int i, int j, int step, int candy) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == -1 || vis[i][j]) {
            return;
        }
        if (grid[i][j] == -2) {
            if (step < ansStep) {
                ans = candy;
                ansStep = step;
            } else if (step == ansStep) {
                ans = Math.max(ans, candy);
            }
            return;
        }

        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int di = DIRS[k][0], dj = DIRS[k][1];
            dfs(i + di, j + dj, step + 1, candy + (grid[i][j] == -3 ? 0: grid[i][j]));
        }
        vis[i][j] = false;
    }

}
