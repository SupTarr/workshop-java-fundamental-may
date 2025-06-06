package dev.suptarr.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

import dev.suptarr.demo.model.PrimeCalculator;

public class PrimeCalculatorTest {

    private final PrimeCalculator primeCalculator = new PrimeCalculator();

    @Test
    public void testFirstPrime() {
        assertThat(primeCalculator.nth(1)).isEqualTo(2);
    }

    @Test
    public void testSecondPrime() {
        assertThat(primeCalculator.nth(2)).isEqualTo(3);
    }

    @Test
    public void testSixthPrime() {
        assertThat(primeCalculator.nth(6)).isEqualTo(13);
    }

    @Test
    public void testBigPrime() {
        assertThat(primeCalculator.nth(10001)).isEqualTo(104743);
    }

    @Test
    public void testUndefinedPrime() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> primeCalculator.nth(0));
    }

}
