package nl.codecraftr.sandbox.fizzbuzz;

public class FizzBuzz {
    public static String parse(int number) {
        if (number % 15 == 0) return "FizzBuzz";
        if (number % 5 == 0) return "Buzz";
        if (number % 3 == 0) return "Fizz";
        return "" + number;
    }
}
