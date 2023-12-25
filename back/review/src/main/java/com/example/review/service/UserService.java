package com.example.review.service;

import com.example.review.entity.UserEntity;
import com.example.review.exception.EmailAlreadyExistException;
import com.example.review.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void registrateUser(UserEntity userEntity) throws EmailAlreadyExistException {
        if (userRepo.findByEmail(userEntity.getEmail()) != null){
            throw new EmailAlreadyExistException("Користувач з такою електронною поштою вже існує");
        }
        userRepo.save(userEntity);
    }

}
