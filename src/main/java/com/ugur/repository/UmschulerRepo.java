package com.ugur.repository;

import com.ugur.domain.Umschuler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UmschulerRepo extends JpaRepository<Umschuler,Long> {


    Optional<Umschuler> findByUsername(String username);
}
