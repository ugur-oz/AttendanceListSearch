package com.ugur.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/umschuler").setViewName("umschuler");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/dozent").setViewName("dozent");
        registry.addViewController("/verwaltung").setViewName("verwaltung");
        registry.addViewController("/login").setViewName("login");
    }
}