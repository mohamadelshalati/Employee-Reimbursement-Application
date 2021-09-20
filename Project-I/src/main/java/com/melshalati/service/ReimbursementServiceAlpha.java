package com.melshalati.service;

import com.melshalati.model.Employee;
import com.melshalati.model.Reimbursement;
import com.melshalati.repository.ReimbursementsRepoJdbc;

import java.sql.SQLException;
import java.util.List;

public class ReimbursementServiceAlpha implements ReimbursementService{
    private static ReimbursementService reimbursementService;

    private ReimbursementServiceAlpha(){}

    public static ReimbursementService getInstance(){
        if(reimbursementService == null){
            reimbursementService = new ReimbursementServiceAlpha();
        }
        return reimbursementService;
    }

    @Override
    public boolean insert(Reimbursement reimbursement) {
        return ReimbursementsRepoJdbc.getInstance().insert(reimbursement);
    }

    @Override
    public Reimbursement select(Reimbursement reimbursement) {
        return ReimbursementsRepoJdbc.getInstance().select(reimbursement);
    }

    @Override
    public List<Reimbursement> selectAll() {
        return ReimbursementsRepoJdbc.getInstance().selectAll();
    }

    @Override
    public List<Reimbursement> selectAllEmpReimbursements(Employee employee) {
        return ReimbursementsRepoJdbc.getInstance().selectAllEmpReimbursements(employee);
    }

    @Override
    public boolean update(Reimbursement reimbursement){
        return ReimbursementsRepoJdbc.getInstance().update(reimbursement);
    }
}
