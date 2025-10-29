package hwod.mini;

/**
 * @author dongzhenxun
 * @date 2025/10/29 下午8:37
 * @description 描述
 */
public class FBWGSolution1 implements handleFBWG {

    @Override
    public String handle(int num) {
        // if else屎山
        if (num < 1 || num > 200) {
            return "error";
        }

        if (num % 3 == 0 && num % 5 == 0 && num % 7 == 0) {
            return "FizzBuzzWhizz";
        } else if (num % 3 == 0 && num % 5 == 0) {
            return "FizzBuzz";
        } else if (num % 3 == 0 && num % 7 == 0) {
            return "FizzWhizz";
        } else if (num % 5 == 0 && num % 7 == 0) {
            return "BuzzWhizz";
        } else if (num % 3 == 0) {
            return "Fizz";
        } else if (num % 5 == 0) {
            return "Buzz";
        } else if (num % 7 == 0) {
            return "Whizz";
        } else {
            return String.valueOf(num);
        }
    }
}
