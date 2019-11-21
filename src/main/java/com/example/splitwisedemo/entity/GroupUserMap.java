package com.example.splitwisedemo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
@Builder
public class GroupUserMap {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = true)
    private long id;
    @Column(name = "group_id")
    private long groupId;
    @Column(name = "user_id")
    private long userId;
}
