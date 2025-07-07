package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author dongzhenxun
 * @date 2025/6/28 下午5:12
 * @description 寻找最大价值的矿堆
 */
public class Main11 {
    
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder();
        String line;
        int m = 0;
        int n = 0;
        while ((line = in.readLine()) != null && !line.isEmpty()) {
            n = line.length();
            m++;
            input.append(line);
        }
        int[][] island = new int[m][n];
        int p = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                island[i][j] = input.charAt(p) - '0';
                p++;
            }
        }
        Main11 main = new Main11();
        main.solution(island);
    }

    public void solution(int[][] island) {
        int ans = 0;
        int m = island.length, n = island[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (island[i][j] != 0) {
                    int tmp = dfs(island, i, j);
                    ans = Math.max(ans, tmp);
                }
            }
        }
        System.out.println(ans);
    }
    
    public int dfs(int[][] island, int i, int j) {
        int m = island.length, n = island[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || island[i][j] == 0) {
            return 0;
        }
        int summ = island[i][j];
        island[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            summ += dfs(island, i + DIRS[k][0], j + DIRS[k][1]);
        }
        return summ;
    }

}
