package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author dongzhenxun
 * @date 2025/6/30 下午3:29
 * @description 描述
 */
public class Main36 {

    class Node implements Comparable<Node> {
        int x, y, px, py, v, direction;

        public Node(int x, int y, int px, int py, int v, int direction) {
            this.x = x;
            this.y = y;
            this.px = px;
            this.py = py;
            this.v = v;
            this.direction = direction;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.v, o.v);
        }
    }

    public static void main(String[] args) throws IOException {
        Main36 main = new Main36();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = params[0], m = params[1];
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int cost = Integer.parseInt(in.readLine());
        int[] start = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        main.solution(grid, cost, start, end);
    }

    public void solution(int[][] grid, int cost, int[] start, int[] target) {
        // 上, 右, 下, 左
        final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dist = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int k = 0; k < 4; k++) {
            dist[start[0]][start[1]][k] = 0;
            pq.add(new Node(start[0], start[1], -1, -1, 0, k));
        }

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            for (int k = 0; k < 4; k++) {
                int nx = curr.x + DIRS[k][0];
                int ny = curr.y + DIRS[k][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (nx == curr.px && ny == curr.py) continue;

                int newCost = curr.v + cost;
                // 如果不是右转
                if (!((curr.direction + 1) % 4 == k)) {
                    newCost += grid[curr.x][curr.y];
                }

                if (newCost < dist[nx][ny][k]) {
                    dist[nx][ny][k] = newCost;
                    pq.add(new Node(nx, ny, curr.x, curr.y, newCost, k));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            ans = Math.min(ans, dist[target[0]][target[1]][k]);
        }
        System.out.println(ans);
    }

}