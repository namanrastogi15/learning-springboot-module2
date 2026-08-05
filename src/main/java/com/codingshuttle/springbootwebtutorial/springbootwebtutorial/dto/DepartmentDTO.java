package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotations.PasswordValidation;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//POJO Class
public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "title can't be blank")
    private  String title;

    @AssertTrue(message = "isActive must be set true")
    private Boolean isActive;

    @PastOrPresent(message = "Department can be created in Past or Present Dates")
    private LocalDate createdAt;

    @PasswordValidation
    private String Password;
}
