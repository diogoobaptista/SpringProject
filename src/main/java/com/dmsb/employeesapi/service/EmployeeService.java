package com.dmsb.employeesapi.service;

import com.dmsb.employeesapi.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Optional<Employee> getEmployee(long id);

    void deleteEmployee(long id);

    Employee updateEmployee(long id, Employee employee);

    List<Employee> getEmployeesByName(String name);
}
