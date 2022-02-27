package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String HelloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        // System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "goodbye";
    }

    @GetMapping
    public String main() {
        return "main";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a") int a,
                             @RequestParam(value = "b") int b,
                             @RequestParam(value = "action") String action,
                             Model model) {
        double result = 0.00;

        switch (action) {
            case "multiplication":
                result = a * (double) b;
                model.addAttribute("result", result);
                model.addAttribute("action", "multiplication");
                break;
            case "addition":
                result = a + b;
                model.addAttribute("result", result);
                model.addAttribute("action", "addition");
                break;
            case "subtraction":
                result = a - b;
                model.addAttribute("result", result);
                model.addAttribute("action", "subtraction");
                break;
            case "division":
                result = a / (double) b;
                model.addAttribute("result", result);
                model.addAttribute("action", "division");
                break;
            default:
                model.addAttribute("result", result);
                model.addAttribute("action", "You don't choose action");
                break;

        }
        return "calculator";
    }
}
