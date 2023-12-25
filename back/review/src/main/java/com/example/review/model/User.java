package com.example.review.model;

import com.example.review.entity.UserEntity;

public class User {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public static User toModel(UserEntity userEntity){
        User model = new User();
        model.setId(userEntity.getId());
        model.setFirstname(userEntity.getFirstname());
        model.setLastname(userEntity.getLastname());
        model.setEmail(userEntity.getEmail());
        model.setPhone(userEntity.getPhone());
        return model;
    }
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
