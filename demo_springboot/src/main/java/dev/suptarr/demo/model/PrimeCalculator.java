package dev.suptarr.demo.model;

import java.util.ArrayList;
import java.util.List;

public class PrimeCalculator {
    public int nth(int nth) throws IllegalArgumentException {
        if (nth <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        }

        List<Integer> primes = new ArrayList<>();
        if (nth == 1) {
            return 2;
        }

        primes.add(2);
        int num = 3;
        while (primes.size() < nth) {
            boolean isPrime = true;
            int limit = (int) Math.sqrt(num);
            for (int p : primes) {
                if (p > limit) {
                    break;
                }
                
                if (num % p == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(num);
            }

            num += 2;
        }

        return primes.get(nth - 1);
    }
}
