package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dongzhenxun
 * @date 2025/6/28 下午8:51
 * @description 数字游戏
 */
public class Main17 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Main17 main = new Main17();
        while ((line = in.readLine()) != null && !line.isEmpty()) {
            int[] params = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = params[0], m = params[1];
            int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            main.solution(arr, n, m);
        }
    }

    private void solution(int[] arr, int n, int m) {
        Set<Long> set = new HashSet<>();
        long summ = 0L;
        for (int i = 0; i < n; i++) {
            summ += arr[i];
            if (set.contains(summ % m)) {
                System.out.println(1);
                return;
            }
            set.add(summ % m);
        }
        if (summ % m == 0) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}
