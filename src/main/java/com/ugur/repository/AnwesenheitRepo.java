package com.ugur.repository;

import com.ugur.domain.Anwesenheit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnwesenheitRepo extends JpaRepository<Anwesenheit, Long> {
}
