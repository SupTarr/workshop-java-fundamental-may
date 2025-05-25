package dev.suptarr.demo.model;

import java.util.List;

import dev.suptarr.demo.model.exception.ValueNotFoundException;

public class BinarySearch {
    private final List<Integer> numbers;

    public BinarySearch(List<Integer> items) {
        this.numbers = items;
    }

    public int indexOf(int item) throws ValueNotFoundException {
        if (numbers == null || numbers.isEmpty()) {
            throw new ValueNotFoundException("Value not in array");
        }
        
        int start = 0;
        int end = numbers.size() - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (numbers.get(middle) == item) {
                return middle;
            } else if (numbers.get(middle) < item) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        
        throw new ValueNotFoundException("Value not in array");
    }
}