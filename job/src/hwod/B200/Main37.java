package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author dongzhenxun
 * @date 2025/6/30 下午10:07
 * @description 描述
 */
public class Main37 {

    public Set<Integer> used = new HashSet<>();

    public static void main(String[] args) throws IOException {
        Main37 main = new Main37();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            int[] params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = params.length - 1;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = params[j + 1] * params[j + 1];
            }
            main.solution(arr, n);
        }
    }

    private void solution(int[] arr, int n) {
        Arrays.sort(arr);
        int ans = 0;
        for (int i = n - 1; i >= 2; i--) {
            if (used.contains(i)) {
                continue;
            }
            int target = arr[i];
            int left = 0, right = i - 1;
            while (left < right) {
                if (used.contains(left)) {
                    left++;
                    continue;
                }
                if (used.contains(right)) {
                    right--;
                    continue;
                }

                int x = arr[left] + arr[right] - target;
                if (x < 0) {
                    left++;
                } else if (x > 0) {
                    right--;
                } else {
                    ans++;
                    used.add(left);
                    used.add(right);
                    used.add(i);
                    break;
                }
            }
        }

        System.out.println(ans);
    }

}
