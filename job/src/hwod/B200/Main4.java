package hwod.B200;

import java.io.*;
import java.util.*;

/**
 * @author dongzhenxun
 * @date 2025/6/27 下午5:04
 * @description 区间交集
 */
public class Main4 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] num = new int[N][2];
        for (int i = 0; i < N; i++) {
            num[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Main4 main = new Main4();
        Arrays.sort(num, (a, b) -> a[0] - b[0]);
        List<int[]> ans = main.solution(num);
        for (int[] an : ans) {
            System.out.println(an[0] + " " + an[1]);
        }
        in.close();
    }

    public List<int[]> solution(int[][] nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i][1] < nums[j][0]) {
                    continue;
                }
                list.add(new int[]{nums[j][0], nums[i][1]});
            }
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();
        for (int[] l: list) {
            int size = ans.size() - 1;
            if (!ans.isEmpty() && ans.get(size)[1] >= l[0]) {
                 ans.set(size, new int[]{Math.min(ans.get(size)[0], l[0]), Math.max(ans.get(size)[1], l[1])});
            } else {
                ans.add(l);
            }
        }
        return ans;
    }

}
