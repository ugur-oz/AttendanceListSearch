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

    public Umschuler(String username, String firstname, String lastname,String password, boolean enabled) {

        super(username,firstname,lastname,password,enabled);
    }

    public Umschuler() {
    }
}
