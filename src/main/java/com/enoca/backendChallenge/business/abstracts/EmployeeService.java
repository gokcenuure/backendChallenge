package com.enoca.backendChallenge.business.abstracts;

import com.enoca.backendChallenge.core.results.DataResult;
import com.enoca.backendChallenge.core.results.Result;
import com.enoca.backendChallenge.entities.concretes.Employee;
import com.enoca.backendChallenge.entities.dtos.CreateEmployeeDto;
import com.enoca.backendChallenge.entities.dtos.UpdateEmployeeDto;

import java.util.List;

public interface EmployeeService {

    Result create(CreateEmployeeDto employee);

    Result update(UpdateEmployeeDto employee, int id);

    Result delete(int employeeId);

    DataResult<List<Employee>> getAll();

    DataResult<Employee> getByEmployeeId(int employeeId);
}
