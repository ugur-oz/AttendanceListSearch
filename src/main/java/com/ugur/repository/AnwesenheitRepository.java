package com.ugur.repository;

import com.ugur.domain.Anwesenheit;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnwesenheitRepository extends JpaRepository<Anwesenheit, Long> {

    List<Anwesenheit> findAll();

    @Query(value = "SELECT * FROM Users u LEFT JOIN Attendance s ON u.user_id = s.user_id  where u.username  like %:keyword% or s.anwesenheit_id like %:keyword% or s.user_id like %:keyword% or s.datum like %:keyword% or s.signature like %:keyword%", nativeQuery = true)
    List<Anwesenheit> findByKeyword(@Param("keyword") String keyword);

}
