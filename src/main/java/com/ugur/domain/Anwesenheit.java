package com.ugur.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Anwesenheit {
    @Id
    private Long id;

    @Column
    private String umschuler_id;

    @Column
    private LocalDateTime datum;

    @Column
    private String signature;
}
