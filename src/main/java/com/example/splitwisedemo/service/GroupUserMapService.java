package com.example.splitwisedemo.service;

import com.example.splitwisedemo.entity.GroupUserMap;
import com.example.splitwisedemo.repository.GroupUserMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupUserMapService {
    @Autowired
    GroupUserMapRepository groupUserMapRepository;
}
