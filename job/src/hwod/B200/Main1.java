package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author dongzhenxun
 * @date 2025/6/27 下午7:58
 * @description 启动多任务排序
 */
public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (String c: s) {
            String[] parts = c.split("->");
            String from = parts[1], to = parts[0];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            inDegree.merge(to, 1, Integer::sum);
            inDegree.putIfAbsent(from, 0);
        }

        Main1 main = new Main1();
        String[] ans = main.solution(graph, inDegree);
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (String an: ans) {
            stringJoiner.add(an);
        }
        System.out.println(stringJoiner.toString());
    }

    public String[] solution(Map<String, List<String>> graph, Map<String, Integer> inDegree) {
        List<String> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: inDegree.entrySet()){
            String key = entry.getKey();
            Integer val = entry.getValue();
            if (val == 0) {
                list.add(key);
            }
        }

        while (!list.isEmpty()) {
            List<String> tmp = new ArrayList<>();
            for (String s: list) {
                ans.add(s);
                if (!graph.containsKey(s)) {
                    continue;
                }
                for (String c: graph.get(s)) {
                    inDegree.merge(c, -1, Integer::sum);
                    if (inDegree.get(c) == 0) {
                        tmp.add(c);
                    }
                }
            }
            tmp.sort(String::compareTo);
            list = new ArrayList<>(tmp);
        }

        return ans.toArray(String[]::new);
    }


}
