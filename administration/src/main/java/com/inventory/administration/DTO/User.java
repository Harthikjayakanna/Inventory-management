package com.inventory.administration.DTO;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private long phone;

}
