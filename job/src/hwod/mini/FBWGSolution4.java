package hwod.mini;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 使用 Enum + Stream API 的实现
 */
public class FBWGSolution4 implements handleFBWG {

    private enum Rule {
        FIZZ(3, "Fizz"),
        BUZZ(5, "Buzz"),
        WHIZZ(7, "Whizz");

        final int divisor;
        final String word;

        Rule(int divisor, String word) {
            this.divisor = divisor;
            this.word = word;
        }

        boolean match(int n) {
            return n % divisor == 0;
        }
    }

    @Override
    public String handle(int num) {
        if (num < 1 || num > 200) {
            return "error";
        }

        String res = Arrays.stream(Rule.values())
                .filter(r -> r.match(num))
                .map(r -> r.word)
                .collect(Collectors.joining());
        return res.isEmpty() ? String.valueOf(num) : res;
    }
}

