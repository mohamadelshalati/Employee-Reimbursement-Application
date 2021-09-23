package com.melshalati.repository;

import com.melshalati.model.Employee;
import com.melshalati.model.Reimbursement;
import com.melshalati.model.enums.ReimbursementStatus;

import com.melshalati.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public class ReimbursementsRepoJdbc implements ReimbursementsRepository{
    private static ReimbursementsRepository reimbursementsRepository;

    private ConnectionUtil connectionUtil = new ConnectionUtil();
    private Transaction transaction;

    private Session session = connectionUtil.getSession();
    private Query query;


    private ReimbursementsRepoJdbc() {}

    public static ReimbursementsRepository getInstance() {
        if(reimbursementsRepository == null) {
            reimbursementsRepository = new ReimbursementsRepoJdbc();
        }

        return reimbursementsRepository;
    }

    @Override
    public boolean insert(Reimbursement reimbursement) {
        int id;
        transaction = session.beginTransaction();
        id = (int) session.save(reimbursement);
        transaction.commit();
        if(id > 0){
            System.out.println(id);
            return true;
        }
        else {
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Reimbursement select(Reimbursement reimbursement) {
        String hql = "FROM Reimbursement WHERE ticketid=" + reimbursement.getTicketId();
        query = session.createQuery(hql);
        List results = query.list();
        reimbursement = (Reimbursement) results.get(0);
        System.out.println(reimbursement);
        return reimbursement;
    }

    @Override
    public List<Reimbursement> selectAll() {
        query = session.createQuery("from Reimbursement");
        List<Reimbursement> list = query.list();
        return list;
    }
    public List<Reimbursement> selectAllEmpReimbursements(Employee employee){
        query = session.createQuery("FROM Reimbursement WHERE emp_id = " + employee.getEmpID());
        List<Reimbursement> list = query.list();
        return list;
    }

    @Override
    public boolean update(Reimbursement reimbursement){
        transaction = session.beginTransaction();
        session.update(reimbursement);
        transaction.commit();
        return true;
    }

}
