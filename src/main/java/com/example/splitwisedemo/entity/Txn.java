package com.example.splitwisedemo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "txn")
@Builder
public class Txn {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = true)
    private long id;

    @Column(name = "txn_type")
    private Character txnType;

    @Column(name = "entity_type")
    private String entityType;

    @Column(name = "entity_id")
    private String entityId;

    @Column(name = "bill_id")
    private long billId;
}
