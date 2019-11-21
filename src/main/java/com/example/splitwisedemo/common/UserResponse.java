package com.example.splitwisedemo.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse implements BaseResponse {
    private String message;
    private Object response;
}
