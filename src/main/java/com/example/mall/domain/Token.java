package com.example.mall.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Token {
    @Id
    private Long userId;
    private String tokenString;
    private Date expired;
    private Date updated;
}
