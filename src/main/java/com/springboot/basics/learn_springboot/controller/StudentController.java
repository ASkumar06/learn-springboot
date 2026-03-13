package com.springboot.basics.learn_springboot.controller;

import java.util.*;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.basics.learn_springboot.dto.AddStudentDto;
import com.springboot.basics.learn_springboot.dto.StudentDto;

import com.springboot.basics.learn_springboot.service.StudentService;

import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("{studentId}")
    public StudentDto getStudent(@PathVariable int studentId){
        return studentService.getStudentById(studentId);
    }
        // @GetMapping("/student")
        // public StudentDto getStudentById(@RequestParam int id){
        //     return studentService.getStudentById(id);
        // }

    @GetMapping("/list")
    public List<StudentDto> getStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDto> createStudent(@RequestBody AddStudentDto addStudentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(addStudentDto));
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student with id "+studentId+" deleted successfully");
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable int studentId, @RequestBody AddStudentDto addStudentDto){
        StudentDto updatedStudent= studentService.updateStudent(studentId, addStudentDto);
        return ResponseEntity.ok(updatedStudent);
    }
    
}
