package com.melshalati.repository;

import com.melshalati.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    public boolean insert(Employee employee);
    public Employee select(Employee employee);
    public Employee update(Employee employee);
    public List<Employee> selectAll();
    public Employee authenticate(Employee employee);
}
