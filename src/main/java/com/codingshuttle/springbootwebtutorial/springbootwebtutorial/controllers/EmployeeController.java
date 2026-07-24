package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage() {
//        return "Secret message: asdfal@#$DASD";
//    }

    @GetMapping(path = "/{employeeID}")
    public static EmployeeDTO getEmployeeById(@PathVariable(name = "employeeID") Long id){
           return new EmployeeDTO(id , "Naman" , "naman@gmail.com" , 22 , LocalDate.of(2024 , 1 , 21) , true);
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false , name = "inputAge") Integer age,
                                  @RequestParam(required = false) String sortBy){
      return "Hi age " + age + " " + sortBy;
    }

    @PostMapping
    public EmployeeDTO createNewRecord(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(100L);
        return inputEmployee;
    }

    @PutMapping
    public String updateEmployeeId(){
         return "Hello from PuT";
    }

}





