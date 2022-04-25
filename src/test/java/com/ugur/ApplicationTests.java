package com.ugur;


import com.ugur.domain.Umschuler;
import com.ugur.repository.AnwesenheitRepo;
import com.ugur.repository.UmschulerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

/*
	@Autowired
	AnwesenheitRepo anwesenheitRepo;

	@Autowired
	UmschulerRepo umschulerRepo;

	@Test
	public void createUmschuler() {
		Umschuler umschuler = new Umschuler();
		umschuler.setUsername("ugurozasa2w1a");
		umschuler.setFirstname("ugur");
		umschuler.setLastname("oz");
		umschuler.setPassword("pass");
		umschuler.setId(112222173235L); // sürekli baska birsey girmen lazim yoksa hata veriyor cünkü id ve username Unique !!

		umschuler = umschulerRepo.save(umschuler);

		assertEquals("class com.ugur.domain.Umschuler",umschuler.getClass().toString());

		assertNotNull(umschuler.getId());
		assertTrue(umschuler.getId() > 0);

		Optional<Umschuler> umschulerFromDb = umschulerRepo.findById(umschuler.getId());
		assertTrue(umschulerFromDb.isPresent());
		assertEquals("pass",umschulerFromDb.get().getPassword());

		umschulerFromDb = umschulerRepo.findByUsername(umschuler.getUsername());
	}

 */
}


