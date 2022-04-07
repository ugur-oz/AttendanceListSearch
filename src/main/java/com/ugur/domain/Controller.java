package com.ugur.domain;

import com.ugur.domain.Anwesenheit;
import com.ugur.domain.Dozent;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping ("/umschuler")
    public String getAnwesenheit(Model model) {
        return "umschuler";
    }

    @PostMapping("/umschuler")
    public String saveAnwesenheit(Model model, Anwesenheit anwesenheit) {
        model.addAttribute("anwesenheit", anwesenheit);

        System.out.println(anwesenheit);
        return "umschuler";
    }

    @GetMapping("/dozent")
    public String getDozent(Model model){
        return "dozent";
    }
    @PostMapping("/dozent")
    public String saveDozent(Model model, Dozent dozent){
        return "dozent";
    }

}
