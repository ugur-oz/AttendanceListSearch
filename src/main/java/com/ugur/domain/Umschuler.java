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

    public Umschuler(Long id, String password, String username, String firstname, String lastname, List<Anwesenheit> anwesenheitList) {
        super(id, password, username, firstname, lastname);
        this.anwesenheitList = anwesenheitList;
    }

    public Umschuler(Long id, String password, String username, String firstname, String lastname){
        super(id, password, username, firstname, lastname);
    }

    public Umschuler() {
    }
}
