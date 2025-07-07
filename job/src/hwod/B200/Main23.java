package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author dongzhenxun
 * @date 2025/6/29 上午11:59
 * @description 荒岛求生
 */
public class Main23 {

    public static void main(String[] args) throws IOException {
        Main23 main = new Main23();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        main.solution(arr);
    }

    private void solution(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int ans = 0;

        for (int x: arr) {
            if (x > 0) {
                st.push(x);
            } else if (x < 0) {
                while (!st.isEmpty() && x < 0) {
                    int y = st.pop();
                    if (-x >= y) {
                        x += y;
                    } else {
                        st.push(y + x);
                        x = 0;
                    }
                }
                if (x < 0) {
                    ans++;
                }
            } else {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(ans + st.size());
    }

}
