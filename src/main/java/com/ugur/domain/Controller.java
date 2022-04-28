package com.ugur.domain;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@org.springframework.stereotype.Controller
public class Controller {



    @GetMapping("/login")
    public String login() {


        return "login";
    }

    @GetMapping("/umschuler")
    public String showAnwesenheit(Model model) {


        return "umschuler";
    }

    @PostMapping("/umschuler")
    public String saveAnwesenheit(Model model) {

        return "umschuler";
    }

    @GetMapping("/dozent")
    public String getDozent(Model model) {
        return "dozent";
    }

    @PostMapping("/dozent")
    public String saveDozent(Model model) {
        return "dozent";
    }

}
