package com.springboot.basics.learn_springboot.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddStudentDto {
   
    @Size(min=3, max=20, message="Name must be between 3 and 20 characters")
    String name;

   
    @Email(message="Email should be a valid email address")
    String email;
}
