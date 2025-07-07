package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author dongzhenxun
 * @date 2025/6/28 下午4:07
 * @description 爱吃蟠桃的孙悟空
 */
public class Main9 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] tree = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = tree.length;
        int H = Integer.parseInt(in.readLine());
        if (H < N) {
            System.out.println(0);
            return;
        }

        Main9 main = new Main9();
        main.solution(tree, N, H);
    }

    public void solution(int[] tree, int N, int H) {
        int left = 1, right = Integer.MIN_VALUE;
        for (int t: tree) {
            right = Math.max(right, t);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(tree, mid, H)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    public boolean check(int[] tree, int k, int target) {
        int cnt = 0;
        for (int t: tree) {
            cnt += (t % k == 0) ? t / k : t / k + 1;
        }
        return cnt <= target;
    }

}
