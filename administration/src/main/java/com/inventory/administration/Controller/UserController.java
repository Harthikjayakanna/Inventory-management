package com.inventory.administration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.administration.DTO.ResponseStructure;
import com.inventory.administration.DTO.User;
import com.inventory.administration.Service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService ser;

    @PostMapping("/user")
    public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User u) {
        return ser.save(u);
    }

    @GetMapping("/")
    public String getMethodName() {
        String age = "Jerold";
        return age;
    }

    // Get by email and password
    @GetMapping("/verifyEmail")
    public ResponseEntity<ResponseStructure<User>> getByEmailPassword(@RequestParam String email,
            @RequestParam String password) {
        return ser.verifyEmailPassword(email, password);
    }

    // Get by phone and password
    @GetMapping("/verifyPhone")
    public ResponseEntity<ResponseStructure<User>> getByPhonePassword(@RequestParam long phone,
            @RequestParam String password) {
        return ser.verifyPhonePassword(phone, password);
    }

    // Get by Id
    @GetMapping("/user/{id}")
    public ResponseEntity<ResponseStructure<User>> getById(@PathVariable int id) {
        return ser.findById(id);
    }

}
