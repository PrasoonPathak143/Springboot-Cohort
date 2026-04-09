package com.coding.prasoon.module1Introduction.controllers;

import com.coding.prasoon.module1Introduction.dto.EmployeeDTO;
import com.coding.prasoon.module1Introduction.entities.EmployeeEntity;
import com.coding.prasoon.module1Introduction.repositories.EmployeeRepository;
import com.coding.prasoon.module1Introduction.services.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")  // by adding this line, no need to manually add '/employees' to other urls of this controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/getSecretMessage")
    public String getMySecretMessage(){
        return "Secret Message : Prasoon";
    }

    // Use @PathVariable when parameter is an essential part of the URL path that identifies a resource
    // Use @RequestParam when the parameter is optional and used for sorting, filtering and other modifications to the request

    //@GetMapping(path = "/employees/{employeeId}")
    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }

    //@GetMapping(path = "/employees")
    @GetMapping
    public String requestParamsTest(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
        return "Hi Prasoon, Age " + age + " Sort By "+ sortBy;
    }

    @PostMapping
    public String postMappingTest(){
        return "Hello from POST";
    }

    @GetMapping(path = "/allEmployee")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "/create")
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return employeeService.updateEmployeeById(employeeId, employeeDTO);
    }

    @DeleteMapping(path = "/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }

}
