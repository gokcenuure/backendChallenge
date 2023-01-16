package com.enoca.backendChallenge.controllers;


import com.enoca.backendChallenge.business.abstracts.EmployeeService;
import com.enoca.backendChallenge.core.results.DataResult;
import com.enoca.backendChallenge.core.results.Result;
import com.enoca.backendChallenge.entities.concretes.Employee;
import com.enoca.backendChallenge.entities.dtos.CreateEmployeeDto;
import com.enoca.backendChallenge.entities.dtos.UpdateEmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeesController {

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private EmployeeService employeeService;

    @PostMapping("/employee/add")
    public Result create(@RequestBody CreateEmployeeDto employee) {
        return this.employeeService.create(employee);
    }

    @PutMapping("/employee/update/{id}")
    public Result update(@RequestBody UpdateEmployeeDto employee, @PathVariable int id) {
        return this.employeeService.update(employee, id);
    }

    @DeleteMapping("/employee/delete")
    public Result delete(int employeeId) {
        return this.employeeService.delete(employeeId);
    }

    @GetMapping("/employees")
    public DataResult<List<Employee>> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/employee/getById")
    public Result getByEmployeeId(int employeeId) {
        return this.employeeService.getByEmployeeId(employeeId);
    }




}
