package com.ugur.domain;
import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
public class Verwaltung extends Users {
    public Verwaltung(String password, String username, String firstname, String lastname) {
        super(password, username, firstname, lastname);
    }

    public Verwaltung() {
    }
}
