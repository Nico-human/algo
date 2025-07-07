package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author dongzhenxun
 * @date 2025/6/28 下午9:59
 * @description 最大岛屿体积
 */
public class Main19 {

    private int ans = 0;
    private int[][] island;
    private int n, m;
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = params[1], m = params[0];
        int[][] island = new int[n][m];
        for (int i = 0; i < n; i++) {
            island[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Main19 main = new Main19();
        main.solution(island);
    }

    public void solution(int[][] island) {
        this.island = island;
        this.n = island.length;
        this.m = island[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (island[i][j] != 0) {
                    ans = Math.max(ans, dfs(i, j));
                }
            }
        }
        System.out.println(ans);
    }

    public int dfs(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || island[i][j] == 0) {
            return 0;
        }
        int summ = island[i][j];
        island[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            summ += dfs(i + DIRS[k][0], j + DIRS[k][1]);
        }
        return summ;
    }


}
