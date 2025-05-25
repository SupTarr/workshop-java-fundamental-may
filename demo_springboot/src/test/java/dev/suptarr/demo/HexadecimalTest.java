package dev.suptarr.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import dev.suptarr.demo.model.Hexadecimal;

public class HexadecimalTest {

    @Test
    public void testOne() {
        assertThat(Hexadecimal.toDecimal("1")).isEqualTo(1);
    }

    @Test
    public void testC() {
        assertThat(Hexadecimal.toDecimal("c")).isEqualTo(12);
    }

    @Test
    public void test10() {
        assertThat(Hexadecimal.toDecimal("10")).isEqualTo(16);
    }

    @Test
    public void testAf() {
        assertThat(Hexadecimal.toDecimal("af")).isEqualTo(175);
    }

    @Test
    public void test100() {
        assertThat(Hexadecimal.toDecimal("100")).isEqualTo(256);
    }

    @Test
    public void test19ace() {
        assertThat(Hexadecimal.toDecimal("19ace")).isEqualTo(105166);
    }

    @Test
    public void testInvalid() {
        assertThat(Hexadecimal.toDecimal("carrot")).isEqualTo(0);
    }

    @Test
    public void testBlack() {
        assertThat(Hexadecimal.toDecimal("000000")).isEqualTo(0);
    }

    @Test
    public void testWhite() {
        assertThat(Hexadecimal.toDecimal("ffffff")).isEqualTo(16777215);
    }

    @Test
    public void testYellow() {
        assertThat(Hexadecimal.toDecimal("ffff00")).isEqualTo(16776960);
    }
}
