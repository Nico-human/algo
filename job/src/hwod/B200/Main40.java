package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author dongzhenxun
 * @date 2025/7/2 下午2:38
 * @description 机器人走迷宫
 */
public class Main40 {

    public static void main(String[] args) throws IOException {
        Main40 main = new Main40();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = params[0], n = params[1];
        int k = Integer.parseInt(in.readLine());
        String s = "";

    }

}
