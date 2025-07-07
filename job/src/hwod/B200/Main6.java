package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringJoiner;

/**
 * @author dongzhenxun
 * @date 2025/6/27 下午9:25
 * @description 最差产品奖
 */
public class Main6 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        solution(arr, M);
    }

    public static void solution(int[] arr, int M) {
        int n = arr.length;
        StringJoiner ans = new StringJoiner(",");
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i < M - 1) {
                continue;
            }
            ans.add(String.valueOf(arr[dq.peekFirst()]));
            if (dq.peekFirst() == i - M + 1) {
                dq.pollFirst();
            }
        }
        System.out.println(ans);
    }

}
