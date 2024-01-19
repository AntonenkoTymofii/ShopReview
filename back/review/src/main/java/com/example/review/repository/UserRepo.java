package com.example.review.repository;

import com.example.review.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserModel, Long> {
    UserModel findByEmail(String email);
    UserModel findByPhone(String phone);
}
