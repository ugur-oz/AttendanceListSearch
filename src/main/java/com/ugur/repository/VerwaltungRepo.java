package com.ugur.repository;

import com.ugur.domain.Anwesenheit;
import com.ugur.domain.Verwaltung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerwaltungRepo extends JpaRepository<Verwaltung, Long> {
}
