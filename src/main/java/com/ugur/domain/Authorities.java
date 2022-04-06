package com.ugur.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Authorities {

    @Id
    private String username;

    private String authority;

}