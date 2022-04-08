package com.ugur.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Anwesenheit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="umschuler_username")
    private Umschuler umschuler;

    @Column(name = "datum")
    private LocalDateTime datum;

    @Column(name = "signature")
    private String signature;
}
