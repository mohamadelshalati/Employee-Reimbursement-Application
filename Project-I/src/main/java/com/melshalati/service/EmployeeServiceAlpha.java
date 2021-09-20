package com.melshalati.service;

import com.melshalati.model.Employee;
import com.melshalati.repository.EmployeeRepoJdbc;
import com.melshalati.repository.EmployeeRepository;

import java.util.List;

public class EmployeeServiceAlpha implements EmployeeService{
    private static EmployeeService employeeService;

    private EmployeeServiceAlpha(){}

    public static EmployeeService getInstance() {
        if(employeeService == null) {
            employeeService = new EmployeeServiceAlpha();
        }
        return employeeService;
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        return EmployeeRepoJdbc.getInstance().insert(employee);
    }

    @Override
    public Employee select(Employee employee) {
        return EmployeeRepoJdbc.getInstance().select(employee);
    }

    @Override
    public boolean registerEmployeeSecure(Employee employee) {
        return false;
    }

    @Override
    public List<Employee> listAllCustomers() {
        return EmployeeRepoJdbc.getInstance().selectAll();
    }

    @Override
    public Employee authenticate(Employee employee){
        Employee loggedEmployee = EmployeeRepoJdbc.getInstance().authenticate(employee);
        return loggedEmployee;
    }
}
