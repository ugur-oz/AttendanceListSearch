package com.ugur.repository;

import java.util.List;
import java.util.Optional;

import com.ugur.domain.Anwesenheit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AnwesenheitServiceImpl implements AnwesenheitService {

    @Autowired
    private AnwesenheitRepository anwesenheitRepository;

    @Override
    public List<Anwesenheit> getAllAnwesenheit() {
        return anwesenheitRepository.findAll();
    }


    @Override
    public Anwesenheit getAnwesenheitById(long id) {
        Optional<Anwesenheit> optional = anwesenheitRepository.findById(id);
        Anwesenheit anwesenheit = null;
        if (optional.isPresent()) {
            anwesenheit = optional.get();
        } else {
            throw new RuntimeException(" Anwesenheit not found for id :: " + id);
        }
        return anwesenheit;
    }


    @Override
    public Page<Anwesenheit> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.anwesenheitRepository.findAll(pageable);
    }


    public List<Anwesenheit> getAllShops(){
        List<Anwesenheit> list =  (List<Anwesenheit>)anwesenheitRepository.findAll();
        return list;
    }


    public List<Anwesenheit> getByKeyword(String keyword){
        return anwesenheitRepository.findByKeyword(keyword);
    }
}
