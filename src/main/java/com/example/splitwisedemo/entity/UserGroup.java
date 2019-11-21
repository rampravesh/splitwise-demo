package com.example.splitwisedemo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_group")
@Builder
public class UserGroup {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = true)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "user_id")
    private long userId;
}
