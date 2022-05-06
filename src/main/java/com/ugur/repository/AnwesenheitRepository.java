package com.ugur.repository;

import com.ugur.domain.Anwesenheit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnwesenheitRepository extends JpaRepository<Anwesenheit, Long> {

    List<Anwesenheit> findAll();
}
