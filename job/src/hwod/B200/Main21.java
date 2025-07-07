package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author dongzhenxun
 * @date 2025/6/29 上午11:09
 * @description 查找一个有向网络的头节点和尾节点
 */
public class Main21 {

    public static void main(String[] args) throws IOException {
        Main21 main = new Main21();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < 2 * N; i += 2) {
            graph.computeIfAbsent(params[i], k -> new ArrayList<>()).add(params[i + 1]);
            inDegree.putIfAbsent(params[i], 0);
            inDegree.merge(params[i + 1], 1, Integer::sum);
        }

        main.solution(graph, inDegree);
    }

    public void solution(Map<Integer, List<Integer>> graph, Map<Integer, Integer> inDegree) {
        StringJoiner ans = new StringJoiner(" ");
        int nodeNum = inDegree.size();
        Deque<Integer> dq = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            if (val == 0) {
                dq.offer(key);
                ans.add(String.valueOf(key));
                inDegree.remove(key);
                break;
            }
        }

        List<Integer> tmp = new ArrayList<>();
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                Integer node = dq.poll();
                if (!graph.containsKey(node)) {
                    tmp.add(node);
                    continue;
                }
                for (int nextNode: graph.get(node)) {
                    inDegree.merge(nextNode, -1, Integer::sum);
                    if (inDegree.get(nextNode) == 0) {
                        dq.offer(nextNode);
                        inDegree.remove(nextNode);
                    }
                }
            }
        }

        if (!inDegree.isEmpty()) {
            System.out.println(-1);
        } else {
            tmp.sort((a, b) -> a - b);
            for (int t: tmp) {
                ans.add(String.valueOf(t));
            }
            System.out.println(ans);
        }

    }

}
