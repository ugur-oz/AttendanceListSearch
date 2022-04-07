package com.ugur.repository;

import com.ugur.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, String> {
}
