package com.example.review.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String hash;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public static UserModel toModel(UserModel userModel){
        UserModel model = new UserModel();
        model.setId(userModel.getId());
        model.setFirstname(userModel.getFirstname());
        model.setLastname(userModel.getLastname());
        model.setEmail(userModel.getEmail());
        model.setPhone(userModel.getPhone());
        model.setHash(null);
        return model;
    }

    public UserModel() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
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
