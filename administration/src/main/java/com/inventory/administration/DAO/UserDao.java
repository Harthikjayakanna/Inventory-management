package com.inventory.administration.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.administration.DTO.User;
import com.inventory.administration.Repository.UserRepository;

@Repository
public class UserDao {
    @Autowired
    private UserRepository rep;

    public User saveUser(User u) {
        return rep.save(u);
    }

    public User updateUser(User u) {
        return rep.save(u);
    }

    public Optional<User> verifyEmailPassword(String email, String password) {
        return rep.verifyByEmailandPassword(email, password);
    }
    public Optional<User> verifyPhonePassword(long phone,String password){
        return rep.verfyByPhoneandPassword(phone, password);
    }

    public Optional<User> getById(int id) {
        return rep.findById(id);
    }

    public void deleteUser(User u) {
        rep.delete(u);
    }

}
