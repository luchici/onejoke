package com.github.luchici.oktaimpl.controllers;

import com.github.luchici.oktaimpl.services.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class JokeController {

    private final JokeService jokeService;

    @GetMapping
    public String getHome(Model model) {
        String username = "Brad Pitt";
        String joke = jokeService.getJoke();
        model.addAttribute("username", username);
        model.addAttribute("joke", joke);
        return "home";
    }
}
