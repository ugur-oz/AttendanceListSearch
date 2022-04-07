package com.ugur.repository;

import com.ugur.domain.Verwaltung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerwaltungRepo extends JpaRepository<Verwaltung, Long> {
}
