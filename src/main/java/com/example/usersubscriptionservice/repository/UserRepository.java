package com.example.usersubscriptionservice.repository;

import com.example.usersubscriptionservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    // Можно добавить методы по email или другим полям при необходимости
}
