package com.springboot.basics.learn_springboot.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddStudentDto {
    String name;
    String email;
}
