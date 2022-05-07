package com.ugur.repository;

import com.ugur.domain.Anwesenheit;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnwesenheitService {
    List<Anwesenheit> getAllAnwesenheit();

    void saveAnwesenheit(Anwesenheit anwesenheit);

    Anwesenheit getAnwesenheitById(long id);

    void deleteAnwesenheitById(long id);

    Page<Anwesenheit> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);






}


