package com.ugur;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String getstart(){

        return "login";
    }

    @GetMapping("/dozent")
    public String getDozent(){

        return "dozent";
    }

}
