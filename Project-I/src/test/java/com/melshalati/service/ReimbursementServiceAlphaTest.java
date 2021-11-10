package com.melshalati.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.melshalati.model.Employee;
import com.melshalati.model.Reimbursement;
import com.melshalati.model.enums.ReimbursementStatus;
import com.melshalati.model.enums.ReimbursementType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;


class ReimbursementServiceAlphaTest {
    @Test
    public void testInsert(){
        Employee e = new Employee();
        e.setEmpID(7);
        e = EmployeeServiceAlpha.getInstance().select(e);

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setEmployeeID(e.getEmpID());
        reimbursement.setEmployeeName(e.getFirstName()+" "+ e.getLastname());
        reimbursement.setEmployeeID(e.getEmpID());
        reimbursement.setStatus(ReimbursementStatus.PENDING);
        reimbursement.setTicketDesc("FIRST TICKET");
        reimbursement.setType(ReimbursementType.LODGING);
        reimbursement.setSubmitTime(new Date());

        Assertions.assertTrue(ReimbursementServiceAlpha.getInstance().insert(reimbursement));
    }

    @Test
    public void testSelect(){
        Reimbursement r = new Reimbursement();
        r.setTicketId(16);
        Assertions.assertTrue(ReimbursementServiceAlpha.getInstance()
                .select(r).getEmployeeName().equals("mark makr"));
    }

    @Test
    public void testList(){
        Assertions.assertTrue(ReimbursementServiceAlpha.getInstance().selectAll()
                .stream()
                .filter(r-> r.getTicketDesc().equals("FIRST TICKET") && r.getTicketId() == 16)
                .findAny().isPresent());
    }

    @Test
    public void testEmpReimbursements(){
        Employee e = new Employee();
        e.setEmpID(7);
        e = EmployeeServiceAlpha.getInstance().select(e);
        Assertions.assertTrue(ReimbursementServiceAlpha.getInstance()
                .selectAllEmpReimbursements(e)
                .stream().findAny().isPresent());
        Assertions.assertTrue(ReimbursementServiceAlpha.getInstance()
                .selectAllEmpReimbursements(e)
                .stream().filter(r -> r.getTicketId() == 16 && r.getTicketDesc().equals("FIRST TICKET")
                        ).findAny().isPresent());
    }

    @Test
    public void testUpdateReimbursement(){
        Employee e = new Employee();
        e.setEmpID(7);
        e = EmployeeServiceAlpha.getInstance().select(e);
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setTicketId(16);
        reimbursement.setEmployeeName(e.getFirstName()+" "+ e.getLastname());
        reimbursement.setEmployeeID(e.getEmpID());
        reimbursement.setStatus(ReimbursementStatus.APPROVED);
        reimbursement.setTicketDesc("FIRST TICKET");
        reimbursement.setType(ReimbursementType.LODGING);
        reimbursement.setSubmitTime(new Date());

        Assertions.assertTrue(ReimbursementServiceAlpha.getInstance().update(reimbursement));
    }

}