package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/second")
public class SecondController {

    @GetMapping("/exit")
    public String exit() {
        return "second/exit";
    }

    @GetMapping("/calc")
    public String calc(@RequestParam(value = "a", required = false) int a,
                       @RequestParam(value = "b", required = false) int b,
                       @RequestParam(value = "action", required = false) String action,
                       Model model) {
        float result = 0;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = (float) a / b;
                break;
        }
        model.addAttribute("result", result);
        return "second/calc";
    }
}
