package com.springboot.basics.learn_springboot.service.impl;

import java.util.List;
import java.util.Map;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.basics.learn_springboot.repository.StudentRepository;
import com.springboot.basics.learn_springboot.service.StudentService;
import com.springboot.basics.learn_springboot.dto.AddStudentDto;
import com.springboot.basics.learn_springboot.dto.StudentDto;
import com.springboot.basics.learn_springboot.entity.Student;
import com.springboot.basics.learn_springboot.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    public final ModelMapper modelMapper;


    public List<StudentDto> getAllStudents(){
        return studentRepository.findAll()
        .stream()
        .map(student-> new StudentDto(student.getId(),student.getName(),student.getEmail()))
        .toList();
    }

    public StudentDto getStudentById(int studentId){
        Student student= studentRepository.findById(studentId)
        .orElseThrow(()->new ResourceNotFoundException("Student not found with id:"+studentId));

        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createStudent(AddStudentDto addStudentDto) {
        Student newStudent= modelMapper.map(addStudentDto, Student.class);
        Student savedStudent= studentRepository.save(newStudent);
        return modelMapper.map(savedStudent,StudentDto.class);
    }

    @Override
    public void deleteStudent(int studentId) {
        if(!studentRepository.existsById(studentId)){
            throw new ResourceNotFoundException("Student not found with id:"+studentId);
        }
       studentRepository.deleteById(studentId);
    }

    @Override
    public StudentDto updateStudent(int studentId, AddStudentDto addStudentDto) {
       Student student = studentRepository.findById(studentId)
       .orElseThrow(()-> new ResourceNotFoundException("Student not found with id:"+studentId));
       
       modelMapper.map(addStudentDto,student);
       Student updatedStudent= studentRepository.save(student);
       return modelMapper.map(updatedStudent, StudentDto.class);
    }

    @Override
    public StudentDto partialUpdateStudent(int studentId, Map<String, Object> updates) {
      Student student= studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student not found with id:"+studentId));
       
        updates.forEach((field,value)->{
            switch(field){
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default: 
                    throw new RuntimeException("field does not exist"+field);
                   
            }
        });
        Student updatedStudent = studentRepository.save(student);
        return modelMapper.map(updatedStudent, StudentDto.class);
    }

    

    
}
