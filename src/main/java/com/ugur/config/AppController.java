package com.ugur.config;


import com.ugur.domain.Anwesenheit;
import com.ugur.domain.AnwesenheitForm;
import com.ugur.domain.Role;
import com.ugur.domain.User;
import com.ugur.repository.AnwesenheitRepository;
import com.ugur.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AppController {

    //klassenlist app da signature var
    @Autowired
    AnwesenheitRepository anwesenheitRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = service.get(id);
        List<Role> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "edit_user";
    }

    @GetMapping("/newUser")
    public String saveUserr(Model model, User user) {
        List<Role> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "newUser";
    }

    @RequestMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/users";
    }

    @PostMapping("/users/save")
    public String saveUser(User user) {
        service.save(user);
        return "redirect:/users";
    }


    @GetMapping("/anwesenheit")
    public String getSignature(Model model) {
        model.addAttribute("user",
                userRepository.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));

        model.addAttribute("anwesenheitForm", new AnwesenheitForm());

        /*
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, dd.MM.uuuu");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");

        LocalDateTime date = LocalDateTime.now();
        model.addAttribute("date", dateTimeFormatter.format(date));
        model.addAttribute("time", timeFormatter.format(date));
         */

        return "anwesenheit";
    }

    @PostMapping("/anwesenheit")
    public String saveSignature(AnwesenheitForm anwesenheitForm) {
        Anwesenheit anwesenheit = new Anwesenheit();

        anwesenheit.setDate(LocalDateTime.parse(anwesenheitForm.getDate()));
        anwesenheit.setSignature(anwesenheitForm.getSignature());
        anwesenheit.setUser(userRepository.getById(anwesenheitForm.getUserid()));

        anwesenheitRepository.save(anwesenheit);
        return "redirect:logout";
    }

    @GetMapping("/monatlich")
    public String schowMonatlich(Model model, Anwesenheit anwesenheit) throws IOException {

        model.addAttribute("anwesenheitsListe", anwesenheitRepository.findAll());
        return "monatlich";
    }

}
