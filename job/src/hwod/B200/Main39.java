package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author dongzhenxun
 * @date 2025/7/1 下午4:25
 * @description 伐木工
 */
public class Main39 {

    public static int[] dp = new int[51];
    public static List<List<Integer>> ans = new ArrayList<>();

    static {
        ans.add(new ArrayList<>());
        for (int i = 1; i <= 4; i++) {
            dp[i] = i;
            ans.add(new ArrayList<>());
            ans.get(i).add(i);
        }

        for (int i = 5; i <= 50; i++) {
            int tmp = 0;
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 1; j <= i / 2; j++) {
                int x = dp[j] * dp[i - j];
                if (x > tmp || (x == tmp && (ans.get(j).size() + ans.get(i - j).size() < tmpList.size()))) {
                    tmp = x;
                    tmpList = new ArrayList<>();
                    tmpList.addAll(ans.get(j));
                    tmpList.addAll(ans.get(i - j));
                }
            }
            dp[i] = tmp;
            ans.add(tmpList);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringJoiner sj = new StringJoiner(" ");
        for (int x: ans.get(n)) {
            sj.add(String.valueOf(x));
        }
        System.out.println(sj);
    }

}
