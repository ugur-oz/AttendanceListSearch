package com.ugur.repository;

import com.ugur.domain.Umschuler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UmschulerRepo extends JpaRepository<Umschuler,String> {
}
