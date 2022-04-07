package com.ugur.repository;

import com.ugur.domain.Anwesenheit;
import com.ugur.domain.Dozent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DozentRepo extends JpaRepository<Dozent, Long> {
}
