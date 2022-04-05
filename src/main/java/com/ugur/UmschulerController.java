package com.ugur;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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












    /*


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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest httpServletRequest, Model model) {
        if(httpServletRequest.isUserInRole("ADMIN")) {
            return "verwaltung";
        } else if(httpServletRequest.isUserInRole("USER")) {
            return "umschuler";
        } else {
            return "dozent";
        }
    }
}
*/