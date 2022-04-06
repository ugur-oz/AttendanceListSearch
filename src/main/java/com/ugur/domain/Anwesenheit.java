package com.ugur.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class Anwesenheit {
    @Id
    private long id;

    @Column
    private long umschuler_id;

    @Column
    private Timestamp datum;

    @Column
    private String signature;

}
