package fizz_buzz_00;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 30);
        // Solution1: for loop
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 3 == 0 && numbers.get(i) % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (numbers.get(i) % 3 == 0) {
                System.out.println("Fizz");
            } else if (numbers.get(i) % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(numbers.get(i));
            }
        }

        System.out.println("-----------------------------");
        // Solution2: use class and method
        FizzBuzz fizzBuzz = new FizzBuzz(numbers);
        fizzBuzz.print();

        System.out.println("-----------------------------");
        List<String> result = new ArrayList<>();
        numbers.forEach(number -> result.add(FizzBuzz.say(number)));
    }
}
