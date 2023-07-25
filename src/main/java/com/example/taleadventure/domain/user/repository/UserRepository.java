package com.example.taleadventure.domain.user.repository;

import com.example.taleadventure.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
