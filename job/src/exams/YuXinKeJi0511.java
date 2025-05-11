package exams;
import java.util.*;
import java.io.*;

/**
 * @author dongzhenxun
 * @date 2025/5/11 下午9:00
 * @description 宇信科技笔试
 */
public class YuXinKeJi0511 {

    class Solution1 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = arr[0];
            int x = arr[1];
            int y = arr[2];
            double ans = solution(n, x, y);
            System.out.println(ans);
        }

        public static double solution(int n, int x, int y) {
            double time = x + (y - x) / 2.0;
            return time * (n - 1);
        }
    }

// solution2
//    def main():
//        T = int(input().strip())
//        groups = []
//        curr_group = []
//        for line in sys.stdin:
//            line = line.strip()
//            if line == "=====":
//                if curr_group:
//                    groups.append("\n".join(curr_group))
//                    curr_group = []
//            else:
//                curr_group.append(line)
//        if curr_group:
//            groups.append("\n".join(curr_group))
//        for group in groups:
//            line_cnt, word_cnt, char_cnt = solution(group)
//            print(f"{line_cnt} {word_cnt} {char_cnt}")
//
//    def solution(data: list):
//        lines = data.split('\n')
//        line_cnt = len(lines)
//
//        words = []
//        for line in lines:
//            words.extend(line.split())
//        word_cnt = len(words)
//
//        char_cnt = sum(len(line) for line in lines)
//        return line_cnt, word_cnt, char_cnt
//
//    if __name__ == '__main__':
//        main()



// solution3
//    def main():
//        T = int(input())
//        for _ in range(T):
//            n, m, x = map(int, input().split())
//            scores = []
//            for _ in range(n):
//                a, b = map(int, input().split())
//                scores.append([a, b])
//            ans = solution(n, m, x, scores)
//            print(ans)
//
//    def solution(n: int, m: int, x: int, scores: list) -> str:
//        target = scores[x - 1][0]
//        for i in range(n):
//            if i == x - 1:
//                continue
//            if m - scores[i][1] > target:
//                return 'No'
//        return 'Yes'
//
//    if __name__ == '__main__':
//        main()

}