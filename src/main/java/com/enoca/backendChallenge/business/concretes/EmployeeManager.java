package com.enoca.backendChallenge.business.concretes;

import com.enoca.backendChallenge.business.abstracts.EmployeeService;
import com.enoca.backendChallenge.core.results.*;
import com.enoca.backendChallenge.dataAccess.abstracts.EmployeeRepository;
import com.enoca.backendChallenge.entities.concretes.Employee;
import com.enoca.backendChallenge.entities.dtos.CreateEmployeeDto;
import com.enoca.backendChallenge.entities.dtos.UpdateEmployeeDto;
import com.enoca.backendChallenge.exceptions.EmployeeNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;


    @Override
    public Result create(CreateEmployeeDto employee) {
        Employee employeeToCreate = modelMapper.map(employee, Employee.class);
            this.employeeRepository.save(employeeToCreate);
            return new SuccessResult("Employee added");
    }


    @Override
    public Result update(UpdateEmployeeDto employee, int id) {
        Employee UpdateEmployeeDto = modelMapper.map(employee, Employee.class);
        Employee employeToUpdate = this.getByEmployeeId(id).getData();

        employeToUpdate.setName(employee.getName());
        employeToUpdate.setSurname(employee.getSurname());
        employeToUpdate.setEmail(employee.getEmail());
        employeToUpdate.setPassword(employee.getPassword());
        employeToUpdate.setPassword(employee.getPassword());
        employeToUpdate.setPosition(employee.getPosition());

            employeeRepository.save(employeToUpdate);
            return new SuccessResult("Employee updated");
    }

    @Override
    public Result delete(int employeeId) {

            Employee employee = this.employeeRepository.getById(employeeId);
            employeeRepository.delete(employee);
            return new SuccessResult("Employee deleted");
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>
                (this.employeeRepository.findAll(),"Employees listed");
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
