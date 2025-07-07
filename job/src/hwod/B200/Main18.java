package hwod.B200;

import java.io.*;
import java.util.*;

/**
 * @author dongzhenxun
 * @date 2025/6/28 下午10:13
 * @description 组装最大可靠性设备
 */
public class Main18 {

    private List<List<int[]>> list;
    private int[] reliabilities;
    private int S, N;

    public static void main(String[] args) throws IOException {
        Main18 main = new Main18();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        main.N = params[1];
        main.S = params[0];
        int m = Integer.parseInt(in.readLine());
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < main.N; i++) {
            list.add(new ArrayList<>());
        }
        int[] maxx = new int[main.N];

        for (int i = 0; i < m; i++)  {
            params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int idx = params[0], reli = params[1], price = params[2];
            list.get(idx).add(new int[]{reli, price});
            maxx[idx] = Math.max(maxx[idx], reli);
        }

        int right = Integer.MAX_VALUE;
        for (int i = 0; i < main.N; i++) {
            right = Math.min(right, maxx[i]);
        }

        TreeSet<Integer> relis = new TreeSet<>((a, b) -> a - b);
        for (int i = 0; i < main.N; i++) {
            int size = list.get(i).size();
            list.get(i).sort((a, b) -> a[0] - b[0]);
            for (int j = 0; j < size; j++) {
                int x = list.get(i).get(j)[0];
                if (x > right) {
                    continue;
                }
                relis.add(x);
            }
        }

        main.list = list;
        main.reliabilities = relis.stream().mapToInt(Integer::intValue).toArray();
        main.solution();
    }

    public void solution() {
        int left = 0, right = reliabilities.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (judge(reliabilities[mid])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right == -1) {
            System.out.println(-1);
            return;
        }
        System.out.println(reliabilities[right]);
    }

    public boolean judge(int target) {
        int summ = 0;
        for (int i = 0; i < N; i++) {
            List<int[]> tmp = list.get(i);
            int left = 0, right = tmp.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (tmp.get(mid)[0] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left == tmp.size()) {
                return false;
            }
            summ += tmp.get(left)[1];
            if (summ > S) {
                return false;
            }
        }
        return true;
    }
}
