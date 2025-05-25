package dev.suptarr.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Hexadecimal {
    private static final Map<Character, Integer> HEX_DIGITS = createHexMap();
    
    private static Map<Character, Integer> createHexMap() {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            map.put(Character.forDigit(i, 10), i);
        }

        map.put('a', 10);
        map.put('b', 11);
        map.put('c', 12);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 15);
        return map;
    }

    public static int toDecimal(String input) {
        int sum = 0;
        input = input.toLowerCase();
        try {
            for (int i = 0; i < input.length(); i++) {
                Integer digit = HEX_DIGITS.get(input.charAt(input.length() - 1 - i));
                if (digit == null) {
                    return 0;
                }

                sum += (digit * Math.pow(16, i));
            }
        } catch (NumberFormatException e) {
            return 0;
        }

        return sum;
    }
}
