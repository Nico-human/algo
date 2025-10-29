package hwod.mini;

/**
 * @author dongzhenxun
 * @date 2025/10/29 下午8:39
 * @description 描述
 */
public class FBWGSolution2 implements handleFBWG {

    @Override
    public String handle(int num) {
        if (num < 1 || num > 200) {
            return "error";
        }
        StringBuilder sb = new StringBuilder();
        if (num % 3 == 0) {
            sb.append("Fizz");
        }
        if (num % 5 == 0) {
            sb.append("Buzz");
        }
        if (num % 7 == 0) {
            sb.append("Whizz");
        }
        return sb.isEmpty() ? String.valueOf(num) : sb.toString();
    }

}
