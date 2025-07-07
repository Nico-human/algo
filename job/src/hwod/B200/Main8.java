package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author dongzhenxun
 * @date 2025/6/28 下午3:06
 * @description 欢乐的周末
 */
public class Main8 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = params[0], n = params[1];
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            grid[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Main8 main = new Main8();
        main.solution(grid);
    }

    public void solution(int[][] grid) {
        int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Map<Integer, Integer> target = new HashMap<>();
        List<int[]> hua = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    hua.add(new int[]{i, j});
                } else if (grid[i][j] == 3) {
                    target.put(i * 1000 + j, 0);
                }
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(hua.get(0));
        vis[hua.get(0)[0]][hua.get(0)[1]] = true;
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = dq.poll();
                int x = tmp[0], y = tmp[1];
                if (target.containsKey(x * 1000 + y)) {
                    target.merge(x * 1000 + y, 1, Integer::sum);
                }
                for (int j = 0; j < 4; j++) {
                    int nx = x + DIRS[j][0], ny = y + DIRS[j][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny] && grid[nx][ny] != 1) {
                        vis[nx][ny] = true;
                        dq.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        dq.offer(hua.get(1));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = false;
            }
        }
        vis[hua.get(1)[0]][hua.get(1)[1]] = true;
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = dq.poll();
                int x = tmp[0], y = tmp[1];
                if (target.containsKey(x * 1000 + y)) {
                    target.merge(x * 1000 + y, 1, Integer::sum);
                }
                for (int j = 0; j < 4; j++) {
                    int nx = x + DIRS[j][0], ny = y + DIRS[j][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny] && grid[nx][ny] != 1) {
                        vis[nx][ny] = true;
                        dq.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry: target.entrySet()) {
            if (entry.getValue() == 2) {
                ans++;
            }
        }
        System.out.println(ans);
    }

}
