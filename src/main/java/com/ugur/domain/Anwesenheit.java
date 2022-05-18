package com.ugur.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


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


    @Override
    public String toString() {
        return "Anwesenheit{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                ", signature='" + signature + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
