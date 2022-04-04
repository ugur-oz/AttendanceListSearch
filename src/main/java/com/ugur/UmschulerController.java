package com.ugur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class UmschulerController {

    @GetMapping("/")
    public String getstart1() {

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin() {


        return "login";
    }

    @GetMapping("/umschuler")
    public String getUmschuler(){

        return "umschuler";
    }


}
