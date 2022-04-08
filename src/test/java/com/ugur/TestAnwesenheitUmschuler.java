package com.ugur;

import com.ugur.domain.Anwesenheit;
import com.ugur.domain.Umschuler;
import com.ugur.repository.AnwesenheitRepo;
import com.ugur.repository.UmschulerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class TestAnwesenheitUmschuler {

    @Autowired
    AnwesenheitRepo anwesenheitRepo;


    @Test
    void createAnwesenheit() {

        /*


        Anwesenheit anwesenheit = new Anwesenheit();
        anwesenheit.setDatum(LocalDateTime.now());
        anwesenheit.setSignature("signature");
        anwesenheit.setUmschuler("umschuler").;


         */


    }
}
