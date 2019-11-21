package com.example.splitwisedemo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "bill")
@Builder
public class Bill {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = true)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private BigDecimal amount;
}
