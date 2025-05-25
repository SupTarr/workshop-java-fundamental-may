package dev.suptarr.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.suptarr.demo.model.Binary;

@RestController
public class BinaryController {
    @GetMapping("/binary/{base2}")
    public int searchNumber(@PathVariable("base2") String base2) {
        Binary binary = new Binary(base2);
        return binary.getDecimal();
    }
}
