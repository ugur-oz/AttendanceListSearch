package com.ugur.domain;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "username")
    private String username;

    @Column(name= "firstname")
    private String firstname;

    @Column(name= "lastname")
    private String lastname;

    @Column (name= "password")
    private String password;


}
