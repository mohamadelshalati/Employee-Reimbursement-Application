package com.melshalati.service;

import com.melshalati.model.Employee;

import java.util.List;

public interface EmployeeService {
    public boolean insertEmployee(Employee employee);

    public Employee select(Employee employee);

    public boolean registerEmployeeSecure(Employee employee);

    public List<Employee> listAllCustomers();

    public Employee authenticate(Employee employee);
}
