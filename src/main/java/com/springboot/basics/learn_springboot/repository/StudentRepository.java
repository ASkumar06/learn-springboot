package com.springboot.basics.learn_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.basics.learn_springboot.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    
}
