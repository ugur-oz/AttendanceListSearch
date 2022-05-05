package com.ugur.repository;

import com.ugur.domain.Anwesenheit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnwesenheitRepository extends JpaRepository<Anwesenheit, Long> {
}
