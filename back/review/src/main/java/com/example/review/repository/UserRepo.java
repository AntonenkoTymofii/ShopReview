package com.example.review.repository;

import com.example.review.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByPhone(String phone);
}
