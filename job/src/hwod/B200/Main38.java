package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author dongzhenxun
 * @date 2025/7/1 下午3:11
 * @description 竖直四子棋
 */
public class Main38 {

    public int[][] grid;

    public static void main(String[] args) throws IOException {
        Main38 main = new Main38();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = params[0], m = params[1];
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        main.solution(arr, n, m);
    }

    public void solution(int[] arr, int n, int m) {
        // 0: 无, 1: red, 2: blue
        grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], -1);
        }
        for (int i = 0; i < arr.length; i++) {
            switch (judge(i % 2, arr[i] - 1)) {
                case "error": {
                    System.out.println(i + 1 + ",error");
                    return; // error
                }
                case "red": {
                    System.out.printf(i + 1 + ",red");
                    return; // red win
                }
                case "blue": {
                    System.out.println(i + 1 + ",blue");
                    return; // blue win
                }
            }
        }
        System.out.println("0,draw");
    }

    private String judge(int idx, int col) {
        int m = grid.length, n = grid[0].length;
        int pos = m - 1;
        if (col < 0 || col >= n) {
            return "error";
        }
        while (pos >= 0 && grid[pos][col] != -1) {
            pos--;
        }
        if (pos == -1) {
            return "error";
        }

        grid[pos][col] = idx;
        int i = pos, j = col;
        int cnt = 1;

        j--;
        while (j >= 0 && grid[i][j] == idx) {
            cnt++;
            j--;
        }
        j = col + 1;
        while (j < n && grid[i][j] == idx) {
            cnt++;
            j++;
        }
        if (cnt >= 4) {
            return (idx == 0) ? "red" : "blue";
        }

        cnt = 1;
        i = pos - 1;
        j = col;
        while (i >= 0 && grid[i][j] == idx) {
            cnt++;
            i--;
        }
        i = pos + 1;
        while (i < m && grid[i][j] == idx) {
            cnt++;
            i++;
        }
        if (cnt >= 4) {
            return (idx == 0) ? "red" : "blue";
        }

        cnt = 1;
        i = pos - 1;
        j = col - 1;
        while (i >= 0 && j >= 0 && grid[i][j] == idx) {
            cnt++;
            i--;
            j--;
        }
        i = pos + 1;
        j = col + 1;
        while (i < m && j < n && grid[i][j] == idx) {
            cnt++;
            i++;
            j++;
        }
        if (cnt >= 4) {
            return (idx == 0) ? "red" : "blue";
        }

        cnt = 1;
        i = pos + 1;
        j = col - 1;
        while (i < m && j >= 0 && grid[i][j] == idx) {
            cnt++;
            i++;
            j--;
        }
        i = pos - 1;
        j = col + 1;
        while (i >= 0 && j < n && grid[i][j] == idx) {
            cnt++;
            i--;
            j++;
        }
        if (cnt >= 4) {
            return (idx == 0) ? "red" : "blue";
        }

        return "";
    }

}
