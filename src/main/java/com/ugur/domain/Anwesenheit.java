package com.ugur.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "attendance")
public class Anwesenheit {

    @Id
    @Column(name = "anwesenheit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "datum")
    private LocalDateTime date;

    @Column(name = "signature")
    private String signature;
}
