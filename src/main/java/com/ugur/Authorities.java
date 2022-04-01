package com.ugur;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Authorities {

    @Id
    private String username;

    private String authority;

}