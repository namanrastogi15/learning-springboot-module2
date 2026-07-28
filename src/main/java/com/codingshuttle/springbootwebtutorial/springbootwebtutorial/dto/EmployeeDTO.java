package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotations.EmployeeRoleValidation;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotations.PrimeNumberValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//POJO CLASS
public class EmployeeDTO {


    private Long id;

    @NotBlank(message = "Name field cannot be Blank")
    @Size(min = 3  , max = 10 , message = "Name must be greater than 3 char and less than 10 char")
    private String name;

    @NotBlank(message = "Email can't be blank")
    @Email(message =  "Email should be a valid Email")
    private String email;

    @NotNull(message = "Age can't be null")
    @PrimeNumberValidation
    @Max(value= 80 , message = "Age cannnot greater tan 80")
    @Min(value= 18 , message = "Age cannnot less tan 18")
    private Integer age;

    @NotBlank(message = "Role can't be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$" , message = "The role of employee can be USER or ADMIN")
    @EmployeeRoleValidation
    private String role; // Admin , user

    @Digits(integer = 6 , fraction = 2 , message = "Salary can be inthe form XXXXXX.XX")
    @NotNull(message = "Salary of employee cannot be null") @Positive(message = "Salary of employee should be positive")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "Joining date cannot be in future")
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")

    @AssertTrue(message = "Employee should be active")
    private Boolean isActive;


}