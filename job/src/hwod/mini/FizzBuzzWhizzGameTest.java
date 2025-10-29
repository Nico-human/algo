package hwod.mini;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FizzBuzzWhizzGameTest {

    @Test
    public void test_when_input_is_minus_1_should_return_invalid() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(2); // use FBWGSolution2
        assertEquals("error", game.play(-1));
    }

    @Test
    public void test_when_input_is_3_should_return_fizz() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(2); // use FBWGSolution2
        assertEquals("Fizz", game.play(3));
    }

    // --- FBWGSolution2 additional cases ---
    @Test
    public void test_solution2_divisible_by_15_returns_fizzbuzz() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(2);
        assertEquals("FizzBuzz", game.play(15));
    }

    @Test
    public void test_solution2_divisible_by_7_returns_whizz() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(2);
        assertEquals("Whizz", game.play(7));
    }

    @Test
    public void test_solution2_divisible_by_3_5_7_returns_all() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(2);
        assertEquals("FizzBuzzWhizz", game.play(105));
    }

    @Test
    public void test_solution2_non_divisible_returns_number() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(2);
        assertEquals("13", game.play(13));
    }

    @Test
    public void test_solution3_divisible_by_3_returns_fizz() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(3);
        assertEquals("Fizz", game.play(3));
    }

    @Test
    public void test_solution3_divisible_by_5_returns_buzz() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(3);
        assertEquals("Buzz", game.play(5));
    }

    @Test
    public void test_solution3_divisible_by_3_5_7_returns_all() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(3);
        assertEquals("FizzBuzzWhizz", game.play(105));
    }

    @Test
    public void test_solution3_non_divisible_returns_number() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(3);
        assertEquals("29", game.play(29));
    }

    @Test
    public void test_solution4_divisible_by_3_returns_fizz() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(4);
        assertEquals("Fizz", game.play(3));
    }

    @Test
    public void test_solution4_divisible_by_5_returns_buzz() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(4);
        assertEquals("Buzz", game.play(5));
    }

    @Test
    public void test_solution4_divisible_by_3_5_7_returns_all() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(4);
        assertEquals("FizzBuzzWhizz", game.play(105));
    }

    @Test
    public void test_solution4_divisible_by_3_7_returns_all() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(4);
        assertEquals("FizzWhizz", game.play(21));
    }

    @Test
    public void test_solution4_non_divisible_returns_number() {
        FizzBuzzWhizzGame game = new FizzBuzzWhizzGame(4);
        assertEquals("22", game.play(22));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_invalid_index_throws() {
        new FizzBuzzWhizzGame(99);
    }

}
