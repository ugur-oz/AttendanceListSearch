package com.ugur.config;



import com.ugur.domain.Anwesenheit;
import com.ugur.domain.Role;
import com.ugur.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppController {

    //klassenlist app da signature var

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
    public String getSignature(Model model, Anwesenheit anwesenheit){

        return "anwesenheit";
    }

    @PostMapping("/anwesenheit")
    public String saveSignature(Model model,  Anwesenheit anwesenheit){
        model.addAttribute("anwesenheit", anwesenheit);
        System.out.println(anwesenheit.getSignature());
        return "anwesenheit";
    }


}
