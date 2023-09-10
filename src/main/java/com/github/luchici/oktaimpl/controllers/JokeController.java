package com.github.luchici.oktaimpl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class JokeController {

    @GetMapping
    public String getHome(Model model) {
        String username = "Brad Pitt";
        String joke = "55gJJnc986f3s4VY08BHDVjS";
        model.addAttribute("username", username);
        model.addAttribute("joke", joke);
        return "home";
    }
}
