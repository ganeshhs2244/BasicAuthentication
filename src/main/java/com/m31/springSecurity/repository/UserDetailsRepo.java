package com.m31.springSecurity.repository;

import com.m31.springSecurity.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserDetailsRepo extends JpaRepository<CustomUser,Integer> {
    Optional<CustomUser> findByUserName(String userName);
}
