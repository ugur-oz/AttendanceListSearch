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
}
