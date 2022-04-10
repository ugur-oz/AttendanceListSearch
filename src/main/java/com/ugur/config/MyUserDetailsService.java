package com.ugur.config;

import com.ugur.domain.Users;
import com.ugur.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Service de kullanabilirsin
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = usersRepo.findByUsernameIs((username));

        if (user.isPresent()) {
            return org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                    .username(user.get().getUsername())
                    .password(user.get().getPassword()) //TODO: !!!
                    .roles("USER")
                    .build();

        } else {
            throw new UsernameNotFoundException("username " + username + " not found");
        }
    }
}
