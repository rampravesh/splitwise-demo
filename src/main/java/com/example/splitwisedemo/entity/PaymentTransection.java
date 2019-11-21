package com.example.splitwisedemo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payment_transection")
@Data
@Builder
public class PaymentTransection {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = true)
    private long id;


    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "txn_id")
    private long txnId;

    @Column(name = "bill_id")
    private long billId;
}
