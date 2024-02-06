package com.example.review.service;

import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.security.MessageDigest;

class UserServiceTest {

    @Test
    void getByID() {
    }

    @Test
    void getByEmail() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void getMD5Hash() throws Exception{
        String hash = "35454B055CC325EA1AF2126E27707052";
        String password = "ILoveJava";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        Assertions.assertEquals(myHash, hash);
    }
}