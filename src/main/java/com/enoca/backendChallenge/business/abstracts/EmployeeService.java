package com.enoca.backendChallenge.business.abstracts;

import com.enoca.backendChallenge.core.results.DataResult;
import com.enoca.backendChallenge.core.results.Result;
import com.enoca.backendChallenge.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {

    Result create(Employee employee);

    Result update(Employee employee);

    Result delete(int employeeId);

    DataResult<List<Employee>> getAll();

    DataResult<Employee> getByEmployeeId(int employeeId);
}
