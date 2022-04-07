package com.ugur.domain;

import com.ugur.repository.AnwesenheitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    AnwesenheitRepo anwesenheitRepo;


    @GetMapping ("/umschuler")
    public String getAnwesenheit(Model model) {
        return "umschuler";
    }

    @PostMapping("/umschuler")
    public String saveAnwesenheit(Model model, Anwesenheit anwesenheit) {
        model.addAttribute("anwesenheit", anwesenheit);

        System.out.println(anwesenheit);

        anwesenheitRepo.save(anwesenheit);
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
