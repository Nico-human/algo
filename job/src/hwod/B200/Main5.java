package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dongzhenxun
 * @date 2025/6/27 下午8:56
 * @description 书籍堆放
 */
public class Main5 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String[] split = s.substring(2, s.length() - 2).split("],\\[");
        int n = split.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(split[i].split(","))
                    .mapToInt(Integer::parseInt).toArray();
        }

        solution(arr);
    }

    public static void solution(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid) < arr[i][1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (left == list.size()) {
                list.add(arr[i][1]);
            } else {
                list.set(left, arr[i][1]);
            }
        }

        System.out.println(list.size());
    }

}
