package com.spring.demo.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private List<Role> roles;

}
