package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author dongzhenxun
 * @date 2025/6/27 下午9:42
 * @description 人气最高的店铺
 */
public class Main7 {

    private int minSubsidy = Integer.MAX_VALUE;
    private Map<Integer, Integer> shopVote;
    private List<int[]> voter;
    private int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] params = Arrays.stream(in.readLine().split(",")).mapToInt(Integer::parseInt).toArray();

        Main7 main = new Main7();
        main.n = params[0];
        main.m = params[1];
        main.voter = new ArrayList<>();
        main.shopVote = new HashMap<>();
        main.shopVote.put(1, 0);
        for (int i = 0; i < main.n; i++) {
            params = Arrays.stream(in.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            if (params[0] != 1) {
                main.voter.add(new int[]{params[0], params[1]});
            }
            main.shopVote.merge(params[0], 1, Integer::sum);
        }
        main.backTrack(0, 0);
        System.out.println(main.minSubsidy);
    }

    public void backTrack(int idx, int currsubsidy) {
        if (idx == voter.size()) {
            if (judge() && minSubsidy > currsubsidy) {
                minSubsidy = currsubsidy;
            }
            return;
        }

        int[] currVoter = voter.get(idx);
        int shopId = currVoter[0];
        int subsidy = currVoter[1];

        // 不选

        backTrack(idx + 1, currsubsidy);

        // 选
        shopVote.merge(1, 1, Integer::sum);
        shopVote.merge(shopId, -1, Integer::sum);
        backTrack(idx + 1, currsubsidy + subsidy);
        shopVote.merge(shopId, 1, Integer::sum);
        shopVote.merge(1, -1, Integer::sum);
    }

    public boolean judge() {
        int maxx = 0;
        for (Map.Entry<Integer, Integer> entry: shopVote.entrySet()) {
            if (entry.getKey() != 1 && entry.getValue() >= maxx) {
                maxx = entry.getValue();
            }
        }
        return shopVote.get(1) > maxx;
    }



}
