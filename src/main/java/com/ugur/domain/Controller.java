package com.ugur.domain;

import com.ugur.repository.AnwesenheitRepo;
import com.ugur.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    AnwesenheitRepo anwesenheitRepo;

    @Autowired
    UsersRepo usersRepo;


    @GetMapping("/login")
    public String login() {


        return "login";
    }

    @GetMapping("/umschuler")
    public String showAnwesenheit(Model model, Anwesenheit anwesenheit) {
        model.addAttribute("anwesenheitToSave", anwesenheit);
        model.addAttribute("timestamp", LocalDateTime.now());
        System.out.println(anwesenheit);

        return "umschuler";
    }

    @PostMapping("/umschuler")
    public String saveAnwesenheit(Model model, Anwesenheit anwesenheit) {

        return "umschuler";
    }

    @GetMapping("/dozent")
    public String getDozent(Model model) {
        return "dozent";
    }

    @PostMapping("/dozent")
    public String saveDozent(Model model, Dozent dozent) {
        return "dozent";
    }

}
