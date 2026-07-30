package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.services;


import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.exceptions.ResourceNotFoundException;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

//    public EmployeeEntity getEmployeeById(Long id) {
//        return employeeRepository.findById(id).orElse(null);
//    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
//        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
//        return modelMapper.map(employeeEntity, EmployeeDTO.class);

        return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));

    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream().map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class)).collect(Collectors.toList());

    }

    public EmployeeDTO createNewRecord(EmployeeDTO inputEmployee) {
        // to check if user is Admin
        // Log
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);

    }

    public void isExistsByEmployeeId(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) throw new ResourceNotFoundException("Employee not found with id " + employeeId);
    }

    public EmployeeDTO updateEmployeeId(Long employeeId, EmployeeDTO employeeDTO) {
        isExistsByEmployeeId(employeeId);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public boolean deleteEmployeeId(Long employeeId) {
        isExistsByEmployeeId(employeeId);
        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO partialUpdateEmployeeId(Long employeeId, Map<String, Object> updates) {
        isExistsByEmployeeId(employeeId);
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);

    }
}









