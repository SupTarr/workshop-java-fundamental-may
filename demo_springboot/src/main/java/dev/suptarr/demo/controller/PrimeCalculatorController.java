package dev.suptarr.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.suptarr.demo.model.PrimeCalculator;

@RestController
public class PrimeCalculatorController {
    @GetMapping("/prime/{nth}")
    public int searchNumber(@PathVariable("nth") String nth) {
        PrimeCalculator primeCalculator = new PrimeCalculator();
        int n = Integer.parseInt(nth);
        return primeCalculator.nth(n);
    }
}
