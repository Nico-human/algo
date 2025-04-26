package cn.dong.job.io;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dongzhenxun
 * @date 2025/4/26 下午5:35
 * @description acm模式处理输入输出
 */
public class AcmMode {

    public static void template0() throws IOException {
        Scanner in = new Scanner(System.in);
        // write code here
        System.out.println();
    }

    public static void template1() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        // write code here
        // input example
        String s = in.readLine();
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        // print example
        out.write(1);

        // close IO
        out.flush();
        out.close();
        in.close();
    }

    public static void template2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            // write code here
            int a = (int) in.nval;
            in.nextToken();
        }
        out.flush();
        out.close();
        br.close();
    }


}
