package com.example.splitwisedemo.service;

import com.example.splitwisedemo.common.BaseResponse;
import com.example.splitwisedemo.common.UserResponse;
import com.example.splitwisedemo.entity.User;
import com.example.splitwisedemo.entity.UserGroup;
import com.example.splitwisedemo.exceptions.InvalidUserException;
import com.example.splitwisedemo.repository.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserGroupService {
    @Autowired
    UserGroupRepository groupRepository;


    public BaseResponse save(UserGroup user) throws InvalidUserException {
        Optional<UserGroup> u = groupRepository.findById(user.getId());
        if (!u.isPresent())
            throw new InvalidUserException("User already exits");
        groupRepository.save(user);
        return UserResponse.builder().message("created successfully").response(u).build();
    }

    public BaseResponse getUserDetails(Long id) throws InvalidUserException {
        Optional<UserGroup> u = groupRepository.findById(id);
        if (!u.isPresent())
            throw new InvalidUserException("User already exits");
        return UserResponse.builder().message("success").response(u.get()).build();
    }

    public BaseResponse delete(Long id) throws InvalidUserException {
        Optional<UserGroup> u = groupRepository.findById(id);
        if (!u.isPresent())
            throw new InvalidUserException("User not present");
        groupRepository.deleteById(id);
        return UserResponse.builder().message("success").response(u.get()).build();
    }
}
