package com.springboot.basics.learn_springboot.service;
import java.util.*;

import org.jspecify.annotations.Nullable;

import com.springboot.basics.learn_springboot.dto.AddStudentDto;
import com.springboot.basics.learn_springboot.dto.StudentDto;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(int studentId);
    StudentDto createStudent(AddStudentDto addStudentDto);
    void deleteStudent(int studentId);
   
  StudentDto updateStudent(int studentId, AddStudentDto addStudentDto);
}
