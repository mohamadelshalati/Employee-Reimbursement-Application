package com.melshalati.service;

import com.melshalati.model.Employee;
import com.melshalati.model.Reimbursement;

import java.util.List;

public interface ReimbursementService {
    public boolean insert(Reimbursement reimbursement);
    public Reimbursement select(Reimbursement reimbursement);
    public List<Reimbursement> selectAll();
    public List<Reimbursement> selectAllEmpReimbursements(Employee employee);
    public boolean update(Reimbursement reimbursement);
}
