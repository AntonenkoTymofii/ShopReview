package com.example.review.service;

import com.example.review.entity.UserEntity;
import com.example.review.exception.UserEmailAlreadyExistException;
import com.example.review.exception.UserNotFoundException;
import com.example.review.exception.UserPhoneAlreadyExistException;
import com.example.review.model.User;
import com.example.review.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void registrationUser(UserEntity userEntity)
            throws UserEmailAlreadyExistException, UserPhoneAlreadyExistException {
        if (userRepo.findByEmail(userEntity.getEmail()) != null){
            throw new UserEmailAlreadyExistException("Користувач з такою електронною поштою вже існує");
        } else if (userRepo.findByPhone(userEntity.getPhone()) != null) {
            throw new UserPhoneAlreadyExistException("Користувач з таким номером телефону вже існує");
        }
        userRepo.save(userEntity);
    }

    public User getByID(Long id) throws UserNotFoundException {
        if(userRepo.findById(id).isEmpty()) {
            throw new UserNotFoundException("Такого користувача не найдено");
        }
        UserEntity userEntity = userRepo.findById(id).get();
        return User.toModel(userEntity);
    }

    public User getByEmail(String email) throws UserNotFoundException {
        if(userRepo.findByEmail(email) == null) {
            throw new UserNotFoundException("Такого користувача не найдено");
        }
        UserEntity userEntity = userRepo.findByEmail(email);
        return User.toModel(userEntity);
    }

    public Long deleteUser(Long id) throws UserNotFoundException {
        if (userRepo.findById(id).isEmpty()){
            throw new UserNotFoundException("Такого користувача вже не існує");
        }
        userRepo.deleteById(id);
        return id;
    }

    public void updateUser(Long id, UserEntity user)
            throws UserEmailAlreadyExistException,
            UserNotFoundException, UserPhoneAlreadyExistException {
        if(userRepo.findById(id).isEmpty()){
            throw new UserNotFoundException("Такого користувача не існує");
        }
        UserEntity userEntity = userRepo.findById(id).get();

        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhone(user.getPhone());
        if (userRepo.findByEmail(userEntity.getEmail()) != null){
            throw new UserEmailAlreadyExistException("Користувач з такою електронною поштою вже існує");
        } else if (userRepo.findByPhone(userEntity.getPhone()) != null) {
            throw new UserPhoneAlreadyExistException("Користувач з таким номером телефону вже існує");
        }
        userRepo.save(userEntity);
    }
}
