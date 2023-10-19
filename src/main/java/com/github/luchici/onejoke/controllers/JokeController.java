package com.github.luchici.onejoke.controllers;

import com.github.luchici.onejoke.model.UserUpdateFormData;
import com.github.luchici.onejoke.services.JokeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class JokeController {

    private final JokeService jokeService;

    @GetMapping({"/", "/home"})
    public String getHome(Model model) {
        // String joke = jokeService.getJoke();
        String joke = "Test Joke - to be replace form the controller";
        model.addAttribute("joke", joke);
        return "home";
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        UserUpdateFormData userUpdateFormData = new UserUpdateFormData();
        model.addAttribute(userUpdateFormData);
        return "profile";
    }

    @PostMapping("/profile")
    public String updateUserSubmit(@Valid @ModelAttribute UserUpdateFormData userUpdateFormData, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("unsuccessful_update", "Try again!");
        } else {
            model.addAttribute("successful_update", "Successful Update");
        }
        return "profile";
    }

}
