package com.ugur.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class AnwesenheitForm {


    private Long userid;

    private String date;

    private String signature;
}
