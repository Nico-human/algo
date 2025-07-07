package hwod.B200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author dongzhenxun
 * @date 2025/6/29 下午2:25
 * @description 根据IP查找城市
 */
public class Main35 {

    public static void main(String[] args) throws IOException {
        Main35 main = new Main35();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] cities = in.readLine().split(";");
        String[] ips = in.readLine().split(",");

        main.solution(cities, ips);
    }

    public void solution(String[] cities, String[] ips) {
        StringJoiner ans = new StringJoiner(",");

        // IP段 -> cityName
        LinkedHashMap<long[], String> map = new LinkedHashMap<>();
        for (String city: cities) {
            String[] param1 = city.split("=");
            String[] param2 = param1[1].split(",");
            String cityName = param1[0];
            long startIP = ipToNum(param2[0]);
            long endIP = ipToNum(param2[1]);
            map.put(new long[]{startIP, endIP}, cityName);
        }

        for (String ip: ips) {
            ans.add(findCity(ip, map));
        }
        System.out.println(ans);
    }

    public long ipToNum(String ip) {
        String[] parts = ip.split("\\.");
        long res = 0L;
        for (String part: parts) {
            res <<= 8;
            res |= Integer.parseInt(part);
        }
        return res;
    }

    private String findCity(String ip, Map<long[], String> map) {
        long ipNum = ipToNum(ip);
        String bestMatch = "";
        long bestRange = Long.MAX_VALUE;
        for (Map.Entry<long[], String> entry: map.entrySet()) {
            long[] range = entry.getKey();
            long startIP = range[0];
            long endIP = range[1];
            if (startIP <= ipNum && ipNum <= endIP) {
                long currentRange = endIP - startIP;
                if (currentRange < bestRange) {
                    bestMatch = entry.getValue();
                    bestRange = currentRange;
                }
            }
        }
        return bestMatch;
    }

}
