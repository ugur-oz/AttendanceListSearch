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

      if(user == null){
          throw  new UsernameNotFoundException("User could not find");
      }
      return new MyUserDetails(user);
    }
}
