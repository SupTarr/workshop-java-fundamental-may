package dev.suptarr.demo.model;

public class Binary {
    private final String input;

    public Binary(String input) {
        this.input = input;
    }

    public int getDecimal() {
        int sum = 0;
        try {
            for (int i = 0; i < this.input.length(); i++) {
                int digit = Character.getNumericValue(this.input.charAt(this.input.length() - 1 - i));
                if (digit > 1) {
                    return 0;
                }

                sum += (digit * Math.pow(2, i));
            }
        } catch (NumberFormatException e) {
            return 0;
        }

        return sum;
    }
}
