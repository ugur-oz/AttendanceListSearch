package com.ugur.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        String redirectURL = request.getContextPath();

        if (userDetails.hasRole("USER")) {
            redirectURL = "anwesenheit";
        } else if (userDetails.hasRole("CREATOR")) {
            redirectURL = "index";
        } else if (userDetails.hasRole("EDITOR")) {
            redirectURL = "monatlich";
        } else if (userDetails.hasRole("ADMIN")) {
            redirectURL = "index";
        }
        response.sendRedirect(redirectURL);
    }
}