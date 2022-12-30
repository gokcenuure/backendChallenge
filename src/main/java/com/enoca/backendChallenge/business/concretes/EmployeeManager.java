package com.enoca.backendChallenge.business.concretes;

import com.enoca.backendChallenge.business.abstracts.EmployeeService;
import com.enoca.backendChallenge.core.results.DataResult;
import com.enoca.backendChallenge.core.results.Result;
import com.enoca.backendChallenge.core.results.SuccessDataResult;
import com.enoca.backendChallenge.core.results.SuccessResult;
import com.enoca.backendChallenge.dataAccess.abstracts.EmployeeRepository;
import com.enoca.backendChallenge.entities.concretes.Employee;
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
        this.employeeRepository.save(employee);
        return new SuccessResult("Employee edded");
    }

    @Override
    public Result update(Employee employee) {
        Employee employee1 = this.employeeRepository.findById(employee.getEmployeeId()).orElse(null);
        employee1.setPhoneNumber(employee.getPhoneNumber());
        employee1.setEmail(employee.getEmail());
        employee1.setPassword(employee.getPassword());

        employeeRepository.save(employee1);

        return new SuccessResult("Employee updated");
    }

    @Override
    public Result delete(int employeeId) {
        Employee employee = this.employeeRepository.findById(employeeId).orElse(null);
        employeeRepository.delete(employee);
        return new SuccessResult("Employee deleted");
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(this.employeeRepository.findAll(),"Employees listed");
    }

    @Override
    public DataResult<Employee> getByEmployeeId(int employeeId) {
        return new SuccessDataResult<Employee>(this.employeeRepository.getByEmployeeId(employeeId),"Employee found");
    }

}
