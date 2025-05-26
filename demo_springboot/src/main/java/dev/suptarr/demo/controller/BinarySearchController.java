package dev.suptarr.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.suptarr.demo.model.BinarySearch;
import dev.suptarr.demo.model.exception.ValueNotFoundException;

@RestController
public class BinarySearchController {
    List<Integer> sortedList = List.of();
    BinarySearch binarySearch = new BinarySearch(sortedList);

    @GetMapping("/binary-search/{number}")
    public int searchNumber(@PathVariable("number") String number) throws ValueNotFoundException {
        int num = Integer.parseInt(number);
        return binarySearch.indexOf(num);
    }

    @PostMapping("/binary-search")
    public String setSortedList(@RequestBody List<Integer> newList) {
        this.sortedList = newList;
        this.binarySearch = new BinarySearch(this.sortedList);
        return "List updated successfully. New list: " + this.sortedList.toString();
    }
}
