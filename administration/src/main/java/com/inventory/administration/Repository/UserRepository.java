package com.inventory.administration.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventory.administration.DTO.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email=?1 and u.password=?2")
    public Optional<User> verifyByEmailandPassword(String email, String password);
    @Query("select u from User u where u.phone=?1 and u.password=?2")
    public Optional<User> verfyByPhoneandPassword(long phone, String password);

}
