package com.ugur.repository;

import com.ugur.domain.Anwesenheit;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnwesenheitService {
    List<Anwesenheit> getAllAnwesenheit();

    Anwesenheit getAnwesenheitById(long id);

    Page<Anwesenheit> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);






}


