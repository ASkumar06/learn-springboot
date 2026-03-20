package com.springboot.basics.learn_springboot.service;
import java.util.*;



import com.springboot.basics.learn_springboot.dto.AddStudentDto;
import com.springboot.basics.learn_springboot.dto.StudentDto;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(int studentId);
    StudentDto createStudent(AddStudentDto addStudentDto);
    void deleteStudent(int studentId);
   
  StudentDto updateStudent(int studentId, AddStudentDto addStudentDto);
 
  StudentDto partialUpdateStudent(int studentId, Map<String,Object> updates);
}
