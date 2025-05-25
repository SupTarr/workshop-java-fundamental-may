package dev.suptarr.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.suptarr.demo.model.ResistorColor;

@RestController
public class ResistorColorController {
    ResistorColor resistorColor = new ResistorColor();

    @GetMapping("/resistor-colors/")
	public String[] getColors() {
		return resistorColor.colors();
	}

    @GetMapping("/resistor-colors/{color}")
	public int getColorCode(@PathVariable("color") String color) {
		return resistorColor.colorCode(color);
	}
}
