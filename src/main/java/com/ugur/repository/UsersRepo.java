package com.ugur.repository;

import com.ugur.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, String> {
    Optional<Users> findByUsernameIs(String username);
}
