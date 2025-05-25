package dev.suptarr.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.suptarr.demo.model.Hexadecimal;

@RestController
public class HexadecimalController {
    @GetMapping("/hexadecimal/{base16}")
    public int searchNumber(@PathVariable("base16") String base16) {
        Hexadecimal hexadecimal = new Hexadecimal();
        return hexadecimal.toDecimal(base16);
    }
}
