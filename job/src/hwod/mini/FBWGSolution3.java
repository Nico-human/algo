package hwod.mini;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongzhenxun
 * @date 2025/10/29 下午8:42
 * @description 描述
 */
public class FBWGSolution3 implements handleFBWG {

    @Override
    public String handle(int num) {
        if (num < 1 || num > 200) {
            return "error";
        }
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        map.put(7, "Whizz");
        int[] idx = {3, 5, 7};
        for (int i: idx) {
            if (num % i == 0) {
                sb.append(map.get(i));
            }
        }
        return sb.isEmpty() ? String.valueOf(num) : sb.toString();
    }

}
