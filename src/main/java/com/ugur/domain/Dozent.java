package com.ugur.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Dozent extends Users {
    public Dozent() {
    }

    public Dozent(String password, String username, String firstname, String lastname) {
        super(password, username, firstname, lastname);
    }
}
