package com.springboot.basics.learn_springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
}
