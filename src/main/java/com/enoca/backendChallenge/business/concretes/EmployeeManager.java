package com.enoca.backendChallenge.business.concretes;

import com.enoca.backendChallenge.business.abstracts.EmployeeService;
import com.enoca.backendChallenge.core.results.*;
import com.enoca.backendChallenge.dataAccess.abstracts.EmployeeRepository;
import com.enoca.backendChallenge.entities.concretes.Employee;
import com.enoca.backendChallenge.exceptions.EmployeeNotFoundException;
import com.enoca.backendChallenge.exceptions.InvalidEmployeeIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private EmployeeRepository employeeRepository;


    @Override
    public Result create(Employee employee) {
        try {
            if (employee.getEmployeeId() == 0) {
                throw new InvalidEmployeeIdException("Employee id can not be 0");
            }
            this.employeeRepository.save(employee);
            return new SuccessResult("Employee added");
        } catch (InvalidEmployeeIdException ex) {
            return new ErrorResult("Error: " + ex.getMessage());
        }
    }

    @Override
    public Result update(Employee employee) {
        try {
            Employee employee1 = this.employeeRepository.findById(employee.getEmployeeId()).orElse(null);
            if (employee1 == null) {
                throw new EmployeeNotFoundException("Invalid employee id");
            }
            employee1.setPhoneNumber(employee.getPhoneNumber());
            employee1.setEmail(employee.getEmail());
            employee1.setPassword(employee.getPassword());
            employeeRepository.save(employee1);
            return new SuccessResult("Employee updated");
        } catch (EmployeeNotFoundException ex) {
            return new ErrorResult("Error: " + ex.getMessage());
        }
    }

    @Override
    public Result delete(int employeeId) {
        try {
            Employee employee = this.employeeRepository.findById(employeeId).orElse(null);
            if (employee == null) {
                throw new EmployeeNotFoundException("Invalid employee id");
            }
            employeeRepository.delete(employee);
            return new SuccessResult("Employee deleted");
        } catch (EmployeeNotFoundException ex) {
            return new ErrorResult("Error: " + ex.getMessage());
        }
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(this.employeeRepository.findAll(),"Employees listed");
    }

    @Override
    public DataResult<Employee> getByEmployeeId(int employeeId) {
        try {
            Employee employee = this.employeeRepository.findById(employeeId).orElse(null);
            if (employee == null) {
                throw new EmployeeNotFoundException("Invalid employee id");
            }
            return new SuccessDataResult<Employee>(employee,"Employee found");
        } catch (EmployeeNotFoundException ex) {
            return new ErrorDataResult("Error: " + ex.getMessage());
        }
    }

}
