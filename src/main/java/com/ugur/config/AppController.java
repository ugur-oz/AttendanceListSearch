package com.ugur.config;


import com.ugur.domain.Anwesenheit;
import com.ugur.domain.AnwesenheitForm;
import com.ugur.domain.Role;
import com.ugur.domain.User;
import com.ugur.repository.AnwesenheitRepository;
import com.ugur.repository.AnwesenheitService;
import com.ugur.repository.AnwesenheitServiceImpl;
import com.ugur.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    AnwesenheitRepository anwesenheitRepository;

    @Autowired
    private AnwesenheitService anwesenheitService;
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
    public String viewHomePage(Model model,Anwesenheit anwesenheit) throws IOException {
        model.addAttribute("anwesenheitsListe", anwesenheitRepository.findAll());
        return findPaginated(1, "date", "asc", model);
    }

    @GetMapping("page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) throws IOException {
        int pageSize = 10;

        model.addAttribute("anwesenheitsListe", anwesenheitRepository.findAll());
        Page<Anwesenheit> page = anwesenheitService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Anwesenheit> anwesenheitsListe = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("anwesenheitsListe", anwesenheitsListe);
        return "monatlich";
    }
    @Autowired
    private AnwesenheitServiceImpl service2;

    @RequestMapping(path = {"/","/search"})
    public String home(Anwesenheit anwesenheit, Model model, String keyword) {
        if(keyword!=null) {
            List<Anwesenheit> list = service2.getByKeyword(keyword);
            model.addAttribute("anwesenheitsListe", list);
            System.out.print(list);
        }else {
            List<Anwesenheit> list = service2.getAllAnwesenheit();
            model.addAttribute("anwesenheitsListe", list);}
        return "monatlich";
    }
}
