package com.github.luchici.oktaimpl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/jokes")
public class JokeController {

    @GetMapping("/just-one")
    public String getJoke(){
        return "joke";
    }
}
