package nl.codecraftr.sandbox.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {
    @Test
    void a_number_is_returned() {
        assertThat(FizzBuzz.parse(1)).isEqualTo("1");
    }

    @Test
    void fizz_is_returned() {
        assertThat(FizzBuzz.parse(3)).isEqualTo("Fizz");
    }

    @Test
    void buzz_is_returned() {
        assertThat(FizzBuzz.parse(5)).isEqualTo("Buzz");
    }

    @Test
    void fizzbuzz_is_returned() {
        assertThat(FizzBuzz.parse(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void fizzbuzz_is_returned_for_multiples_of_15() {
        assertThat(FizzBuzz.parse(30)).isEqualTo("FizzBuzz");
    }

    @Test
    void fizz_is_returned_with_multiplications_of_3() {
        assertThat(FizzBuzz.parse(48)).isEqualTo("Fizz");
    }

    @Test
    void buzz_is_returned_with_multiplications_of_5() {
        assertThat(FizzBuzz.parse(10)).isEqualTo("Buzz");
    }
}
