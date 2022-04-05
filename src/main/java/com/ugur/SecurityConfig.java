package com.ugur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);//.withUser(User.withUsername("ugur").password(passwordEncoder().encode("ugur")).roles("user"));
        auth.inMemoryAuthentication().withUser("Andi").password(passwordEncoder().encode("andi123")).roles("umschuler").and().withUser("Julius").password(passwordEncoder().encode("julius123")).roles("dozent");
    }


    protected void configure(HttpSecurity http) throws Exception {
        @Autowired DataSource dataSource;

        @Override protected void configure (AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication().dataSource(dataSource);//.withUser(User.withUsername("ugur").password(passwordEncoder().encode("ugur")).roles("user"));
            auth.inMemoryAuthentication().withUser("Andi").password(passwordEncoder().encode("andi123")).roles("umschuler").and().withUser("Julius").password(passwordEncoder().encode("julius123")).roles("dozent");
        }

        @Override protected void configure (HttpSecurity security) throws Exception {
            security.httpBasic().and().authorizeRequests().antMatchers("/h2-console/**", "/", "/login", "/css/**", "/img/**", "/images/**").permitAll().antMatchers((HttpMethod.GET), "/umschuler/**").hasRole("umschuler").antMatchers((HttpMethod.GET), "/dozent/**").hasRole("dozent").antMatchers((HttpMethod.GET), "/verwaltung/**").hasRole("verwaltung").and().formLogin().loginPage("/login").successForwardUrl("/dozent/**")//.successForwardUrl("/umschuler/**").successForwardUrl("/verwaltung/**")
                    .and().logout().invalidateHttpSession(true).clearAuthentication(true).logoutSuccessUrl("/login").permitAll();

            security.csrf().ignoringAntMatchers("/h2-console/**");
            security.headers().frameOptions().sameOrigin();
            security.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/umschuler/**").hasRole("Umschuler").antMatchers((HttpMethod.GET), "/dozent/**").hasRole("dozent").and().csrf().disable();
        }

        @Bean public PasswordEncoder passwordEncoder () {
            return new BCryptPasswordEncoder();
        }
    }
}



    /*
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource);//.withUser(User.withUsername("ugur").password(passwordEncoder().encode("ugur")).roles("user"));
        auth.inMemoryAuthentication()
                .withUser("Andi").password(passwordEncoder().encode("andi123")).roles("umschuler")
                .and()
                .withUser("Julius").password(passwordEncoder().encode("julius123")).roles("dozent");
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception{
        security
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/h2-console/**", "/", "/login", "/css/**", "/img/**","/images/**").permitAll()
                .antMatchers((HttpMethod.GET),"/umschuler/**").hasRole("umschuler")
                .antMatchers((HttpMethod.GET),"/dozent/**").hasRole("dozent")
                .antMatchers((HttpMethod.GET),"/verwaltung/**").hasRole("verwaltung")
                .and().formLogin().loginPage("/login").successForwardUrl("/dozent/**")//.successForwardUrl("/umschuler/**").successForwardUrl("/verwaltung/**")
                .and()
                .logout().invalidateHttpSession(true).clearAuthentication(true).logoutSuccessUrl("/login").permitAll();

        security.csrf().ignoringAntMatchers("/h2-console/**");
        security.headers().frameOptions().sameOrigin();
        security
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/umschuler/**").hasRole("Umschuler")
                .antMatchers((HttpMethod.GET),"/dozent/**").hasRole("dozent")
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource);//.withUser(User.withUsername("ugur").password(passwordEncoder().encode("ugur")).roles("user"));
        auth.inMemoryAuthentication()
                .withUser("Andi").password(passwordEncoder().encode("andi123")).roles("umschuler")
                .and()
                .withUser("Julius").password(passwordEncoder().encode("julius123")).roles("dozent");
    }



    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/classesTable").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/success", true)
                .and()
                .httpBasic();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     */