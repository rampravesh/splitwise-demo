package com.example.splitwisedemo.controller;

import com.example.splitwisedemo.common.BaseResponse;
import com.example.splitwisedemo.common.UserResponse;
import com.example.splitwisedemo.entity.User;
import com.example.splitwisedemo.exceptions.InvalidUserException;
import com.example.splitwisedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/user")
public class UserApiController {

    @Autowired
    UserService userService;

    @GetMapping("test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<String>(
                "Cool",
                HttpStatus.OK);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> create(@RequestBody User user) {
        BaseResponse baseResponse;
        try {
            baseResponse = userService.save(user);
        } catch (InvalidUserException e) {
            baseResponse = UserResponse.builder().message("User already exits").build();
            return new ResponseEntity<BaseResponse>(
                    baseResponse,
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<BaseResponse>(
                baseResponse,
                HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getUserDetails(@PathVariable Long id) {
        BaseResponse baseResponse;
        try {
            baseResponse = userService.getUserDetails(id);
        } catch (InvalidUserException e) {
            baseResponse = UserResponse.builder().message("User not found").build();
            return new ResponseEntity<BaseResponse>(
                    baseResponse,
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<BaseResponse>(
                baseResponse,
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteUser(@PathVariable Long id) {
        BaseResponse baseResponse;
        try {
            baseResponse = userService.delete(id);
        } catch (InvalidUserException e) {
            baseResponse = UserResponse.builder().message("User not found").build();
            return new ResponseEntity<BaseResponse>(
                    baseResponse,
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<BaseResponse>(
                baseResponse,
                HttpStatus.OK);
    }
}
