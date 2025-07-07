package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dongzhenxun
 * @date 2025/6/28 下午8:02
 * @description 信道分配
 */
public class Main16 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int D = Integer.parseInt(in.readLine());

        Main16 main = new Main16();
        main.solution(arr, R, D);
    }

    public void solution(int[] arr, int r, int d) {
        long ans = 0;
        Map<Long, Integer> cnt = new LinkedHashMap<>();
        long summ = 0L;
        for (int i = 0; i <= r; i++) {
            long jie = (long) Math.pow(2, i);
            if (jie >= d) {
                ans += arr[i];
                continue;
            }
            summ += arr[i] * jie;
            cnt.put(jie, arr[i]);
        }

        long tmpSum = 0L;
        while (summ + tmpSum >= d) {
            if (tmpSum >= d) {
                ans++;
                tmpSum = 0;
            }
            int p = 0;
            int size = cnt.size() - 1;
            while (p < size && (tmpSum + (long) Math.pow(2, p)) < d) {
                p++;
            }
            long key = (long) Math.pow(2, p);
            tmpSum += key;
            summ -= key;
            cnt.merge(key, -1, Integer::sum);
            if (cnt.get(key) == 0) {
                cnt.remove(key);
            }
        }

        // 至少装满d
        System.out.println(ans);
    }

}

