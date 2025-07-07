package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author dongzhenxun
 * @date 2025/6/28 下午7:30
 * @description 上班之路/是否能到达公司
 */
public class Main15 {

    private char[][] grid;
    private boolean[][] vis;
    private boolean ans = false;
    private int n;
    private int m;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int t = params[0], c = params[1];
        params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = params[0], m = params[1];
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        Main15 main = new Main15();
        main.solution(grid, t, c);
    }

    public void solution(char[][] grid, int t, int c) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        this.vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'S') {
                    dfs(i, j, t, c, 0);
                    break;
                }
            }
        }
        System.out.println((ans) ? "YES": "NO");
    }
    // dir: 0: 行直线, 1: 列直线
    public void dfs(int i, int j, int t, int c, int dir) {
        if (ans) {
            return;
        }
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || t < 0 || c < 0) {
            return;
        }
        if (grid[i][j] == 'T') {
            ans = true;
            return;
        }

        vis[i][j] = true;
        c = (grid[i][j] == '*') ? c - 1 : c;

        if (grid[i][j] == 'S') {
            dfs(i - 1, j, t, c, 1);
            dfs(i + 1, j, t, c, 1);
            dfs(i, j - 1, t, c, 0);
            dfs(i, j + 1, t, c, 0);
        } else if (dir == 1) {
            dfs(i - 1, j, t, c, 1);
            dfs(i + 1, j, t, c, 1);
            dfs(i, j - 1, t - 1, c, 0);
            dfs(i, j + 1, t - 1, c, 0);
        } else {
            dfs(i - 1, j, t - 1, c, 1);
            dfs(i + 1, j, t - 1, c, 1);
            dfs(i, j - 1, t, c, 0);
            dfs(i, j + 1, t, c, 0);
        }

        vis[i][j] = false;
    }

}
