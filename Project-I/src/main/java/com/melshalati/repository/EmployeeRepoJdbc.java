package com.melshalati.repository;

import com.melshalati.model.Employee;
import com.melshalati.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class EmployeeRepoJdbc implements EmployeeRepository{

    private static EmployeeRepository employeeRepository;

    private ConnectionUtil connectionUtil = new ConnectionUtil();
    private Transaction transaction;
    private Session session = connectionUtil.getSession();
    private Query query;

    private EmployeeRepoJdbc() {}

    public static EmployeeRepository getInstance() {
        if(employeeRepository == null) {
            employeeRepository = new EmployeeRepoJdbc();
        }
        return employeeRepository;
    }

    @Override
    public boolean insert(Employee employee) {
        int id;
        transaction = session.beginTransaction();
        id = (int) session.save(employee);
        if(id > 0){
            return true;
        }
        else
            session.getTransaction().rollback();
            return false;
    }


    @Override
    public Employee select(Employee employee){
        System.out.println( "id = " + employee.getEmpID());
        String hql = "FROM Employee WHERE emp_id=" + employee.getEmpID();
        query = session.createQuery(hql);
        List results = query.list();
        employee = (Employee) results.get(0);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        String hql = "UPDATE Employee set salary = :salary "  +
                "WHERE id = :employee_id";
        query = session.createQuery(hql);
        query.setParameter("salary", 1000);
        query.setParameter("employee_id", 10);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        return null;
    }

    @Override
    public List<Employee> selectAll() {
        query = session.createQuery("from Employee");
        List<Employee> list = query.list();
        return list;
    }

    @Override
    public Employee authenticate(Employee employee) {
        String hql = "FROM Employee WHERE emp_email='" + employee.getEmail() + "'AND emp_password='" + employee.getEmpPassword()+"'";
        query = session.createQuery(hql);
        List results = query.list();
        if (results.size() == 0){
            System.out.println("no match found");
            return null;
        }
        else {
            employee = (Employee) results.get(0);


            return employee;
        }
    }
}
