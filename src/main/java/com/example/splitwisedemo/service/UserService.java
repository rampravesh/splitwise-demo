package com.example.splitwisedemo.service;

import com.example.splitwisedemo.common.BaseResponse;
import com.example.splitwisedemo.common.UserResponse;
import com.example.splitwisedemo.entity.User;
import com.example.splitwisedemo.entity.UserGroup;
import com.example.splitwisedemo.exceptions.InvalidUserException;
import com.example.splitwisedemo.repository.UserGroupRepository;
import com.example.splitwisedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserGroupRepository userGroupRepository;

    public BaseResponse save(User user) throws InvalidUserException {
        User u = userRepository.findByEmail(user.getEmail());
        if (Objects.nonNull(u))
            throw new InvalidUserException("User already exits");
        u = userRepository.save(user);
        userGroupRepository.save(UserGroup.builder().userId(u.getId()).name("Contacts").build());
        return UserResponse.builder().message("created successfully").response(u).build();
    }

    public BaseResponse getUserDetails(Long id) throws InvalidUserException {
        Optional<User> u = userRepository.findById(id);
        if (!u.isPresent())
            throw new InvalidUserException("User already exits");
        return UserResponse.builder().message("success").response(u.get()).build();
    }

    public BaseResponse delete(Long id) throws InvalidUserException {
        Optional<User> u = userRepository.findById(id);
        if (!u.isPresent())
            throw new InvalidUserException("User not present");
        userRepository.deleteById(id);
        return UserResponse.builder().message("success").response(u.get()).build();
    }
}
