package com.example.review.service;

import com.example.review.exception.userExceptions.NotCorrectPasswordExeption;
import com.example.review.model.UserModel;
import com.example.review.exception.userExceptions.UserEmailAlreadyExistException;
import com.example.review.exception.userExceptions.UserNotFoundException;
import com.example.review.exception.userExceptions.UserPhoneAlreadyExistException;
import com.example.review.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void registrationUser(UserModel userModel)
            throws UserEmailAlreadyExistException, UserPhoneAlreadyExistException {
        if (userRepo.findByEmail(userModel.getEmail()) != null){
            throw new UserEmailAlreadyExistException("Користувач з такою електронною поштою вже існує");
        } else if (userRepo.findByPhone(userModel.getPhone()) != null) {
            throw new UserPhoneAlreadyExistException("Користувач з таким номером телефону вже існує");
        }
        userModel.setHash(getMD5Hash(userModel.getHash()));
        userRepo.save(userModel);
    }

    public UserModel getByID(Long id) throws UserNotFoundException {
        if(userRepo.findById(id).isEmpty()) {
            throw new UserNotFoundException("Такого користувача не найдено");
        }
        UserModel userModel = userRepo.findById(id).get();
        return UserModel.toModel(userModel);
    }

    public UserModel getByEmail(String email) throws UserNotFoundException {
        if(userRepo.findByEmail(email) == null) {
            throw new UserNotFoundException("Такого користувача не найдено");
        }
        UserModel userModel = userRepo.findByEmail(email);
        return UserModel.toModel(userModel);
    }
    public UserModel authorizationUser(String email, String password) throws UserNotFoundException,
            NotCorrectPasswordExeption {
        if(userRepo.findByEmail(email) == null) {
            throw new UserNotFoundException("Такого користувача не найдено");
        }
        UserModel userModel = userRepo.findByEmail(email);
        if (!userModel.getHash().equals(getMD5Hash(password))){
            throw new NotCorrectPasswordExeption("Невірно введений пароль");
        }
        return UserModel.toModel(userModel);
    }

    public Long deleteUser(Long id) throws UserNotFoundException {
        if (userRepo.findById(id).isEmpty()){
            throw new UserNotFoundException("Такого користувача вже не існує");
        }
        userRepo.deleteById(id);
        return id;
    }

    public void updateUser(Long id, UserModel user)
            throws UserEmailAlreadyExistException,
            UserNotFoundException, UserPhoneAlreadyExistException {
        if(userRepo.findById(id).isEmpty()){
            throw new UserNotFoundException("Такого користувача не існує");
        }
        UserModel userModel = userRepo.findById(id).get();

        userModel.setFirstname(user.getFirstname());
        userModel.setLastname(user.getLastname());
        userModel.setEmail(user.getEmail());
        userModel.setPhone(user.getPhone());
        if (userRepo.findByEmail(userModel.getEmail()) != null){
            throw new UserEmailAlreadyExistException("Користувач з такою електронною поштою вже існує");
        } else if (userRepo.findByPhone(userModel.getPhone()) != null) {
            throw new UserPhoneAlreadyExistException("Користувач з таким номером телефону вже існує");
        }
        userRepo.save(userModel);
    }

    public String getMD5Hash(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] inputBytes = password.getBytes();
            md.update(inputBytes);
            byte[] mdBytes = md.digest();
            StringBuilder result = new StringBuilder();
            for (byte mdByte : mdBytes) {
                result.append(Integer.toString((mdByte & 0xff) + 0x100, 16)
                        .substring(1));
            }
            return result.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
