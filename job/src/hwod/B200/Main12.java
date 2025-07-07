package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author dongzhenxun
 * @date 2025/6/28 下午5:47
 * @description 完全二叉树非叶子部分后序遍历
 */
public class Main12 {

    private StringJoiner ans = new StringJoiner(" ");

    class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
        public TreeNode(int val) {this.val = val;}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr.length;
        Main12 main = new Main12();
        main.solution(arr, n);
    }

    public void solution(int[] arr, int n) {
        if (n == 1) {
            System.out.println(arr[0]);
        }
        TreeNode root = new TreeNode(arr[0]);
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        int i = 1;
        while (i < n) {
            TreeNode tmp = dq.poll();
            if (i < n) {
                tmp.left = new TreeNode(arr[i]);
                i++;
                dq.offer(tmp.left);
            }
            if (i < n) {
                tmp.right = new TreeNode(arr[i]);
                i++;
                dq.offer(tmp.right);
            }
        }

        dfs(root);
        System.out.println(ans);
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        if (node.left != null || node.right != null) {
            ans.add(String.valueOf(node.val));
        }
    }

}
