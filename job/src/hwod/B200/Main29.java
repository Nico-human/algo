package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringJoiner;

/**
 * @author dongzhenxun
 * @date 2025/6/29 下午12:54
 * @description 篮球游戏
 */
public class Main29 {

    public static void main(String[] args) throws IOException {
        Main29 main = new Main29();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] teacher = Arrays.stream(in.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] student = Arrays.stream(in.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        main.solution(teacher, student);
    }

    public void solution(int[] teacher, int[] student) {
        int n = teacher.length;
        Deque<Integer> dq = new ArrayDeque<>();
        StringJoiner ans = new StringJoiner("");
        int p = 0;
        // First - Last
        for (int i = 0; i < n; i++) {
            dq.addLast(teacher[i]);
            while (!dq.isEmpty() && (p < n) && (dq.peekFirst() == student[p] || dq.peekLast() == student[p])) {
                if (dq.size() == 1) {
                    dq.pollFirst();
                    ans.add("L");
                } else if (dq.peekFirst() == student[p]) {
                    dq.pollFirst();
                    ans.add("L");
                } else if (dq.peekLast() == student[p]) {
                    dq.pollLast();
                    ans.add("R");
                }
                p++;
            }
        }

        System.out.println((ans.length() == n) ? ans: "NO");
    }

}
