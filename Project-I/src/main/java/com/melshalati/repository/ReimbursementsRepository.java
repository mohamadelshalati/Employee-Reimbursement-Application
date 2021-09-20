package com.melshalati.repository;

import com.melshalati.model.Employee;
import com.melshalati.model.Reimbursement;

import java.sql.SQLException;
import java.util.List;

public interface ReimbursementsRepository {
    public boolean insert(Reimbursement reimbursement);
    public Reimbursement select(Reimbursement reimbursement);
    public List<Reimbursement> selectAll();
    public List<Reimbursement> selectAllEmpReimbursements(Employee employee);
    public boolean update(Reimbursement reimbursement);
}
