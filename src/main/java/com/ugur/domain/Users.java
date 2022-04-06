package com.ugur.domain;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Users {
    @Id
    private long username;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String password;

    private boolean enabled;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Authorities authority;

}
