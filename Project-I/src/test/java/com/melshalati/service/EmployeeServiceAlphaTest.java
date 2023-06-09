package com.melshalati.service;
 
import com.melshalati.model.Employee;
import com.melshalati.model.enums.EmployeeRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class EmployeeServiceAlphaTest {
    @Test
    public void testInsertEmployee(){
        Employee e = new Employee();
        e.setLastname("mark");
        e.setEmpUsername("mark");
        e.setEmpPassword("1234");
        e.setFirstName("mark");
        e.setEmail("mark@email.com");
        e.setRole(EmployeeRole.EMPLOYEE);
        Assertions.assertTrue(EmployeeServiceAlpha.getInstance().insertEmployee(e));
    }
    @Test
    public void testSelectEmployee(){
        Employee e = new Employee();
        e.setEmpID(7);
        e = EmployeeServiceAlpha.getInstance().select(e);
        Assertions.assertTrue(e.getFirstName().equals("mark")&&e.getEmail()
                .equals("mark@email.com"));
    }
    @Test
    public void testSelectAllEmployees(){
        Assertions.assertTrue(EmployeeServiceAlpha.getInstance().listAllCustomers().stream().
                filter(e -> e.getEmail().equals("mark@email.com")&&e.getFirstName().equals("mark"))
                .findAny().isPresent());
    }

    @Test
    public void testAuthenticateUser(){
        Employee e = new Employee();
        e.setEmail("mark@email.com");
        e.setEmpPassword("1234");
        Assertions.assertTrue(EmployeeServiceAlpha.getInstance().authenticate(e)
                .getFirstName().equals("mark"));
    }
}
