package com.ugur.config;

/*

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("/admin");
        } else if(roles.contains("ROLE_DOZENT")) {
            httpServletResponse.sendRedirect("/dozent");
        } else {
            httpServletResponse.sendRedirect("/umschuler");
        }

}
    }
*/



