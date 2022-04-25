package com.ugur.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Umschuler extends Users {

    @OneToMany(mappedBy = "umschuler")
    private List<Anwesenheit> anwesenheitList;

    public Umschuler(String password, String username, String firstname, String lastname) {
        super(password, username, firstname, lastname);
    }

    public Umschuler() {
    }
}
