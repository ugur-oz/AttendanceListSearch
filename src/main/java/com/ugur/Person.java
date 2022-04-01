package com.ugur;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    private long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String password;
}
