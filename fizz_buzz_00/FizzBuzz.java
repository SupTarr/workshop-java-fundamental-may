package fizz_buzz_00;

import java.util.List;

public class FizzBuzz {
    private final List<Integer> numbers;

    public FizzBuzz(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static String say(Integer number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "fizz_buzz_00";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return number.toString();
        }
    }

    public void print() {
        for (int i = 0; i < this.numbers.size(); i++) {
            System.out.println(say(this.numbers.get(i)));
        }
    }
}
