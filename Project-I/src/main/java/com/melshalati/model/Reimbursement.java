package com.melshalati.model;

import com.melshalati.model.enums.ReimbursementStatus;
import com.melshalati.model.enums.ReimbursementType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="Reimbursements")
public class Reimbursement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    @Column(name = "reimb_amount", nullable = false)
    private double reimbAmount;

    @Column(name = "ticket_desc")
    private String ticketDesc;

    @Column(name="emp_id", nullable = false)
    private int employeeID;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "sub_time", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date submitTime;

    @Column(name = "res_time")
    @Temporal(TemporalType.DATE)
    private Date resolveTime;

    @Column(name = "reimb_type", nullable = false)
    private ReimbursementType type;

    @Column(name = "reimb_status", nullable = false)
    private ReimbursementStatus status;



    public Reimbursement() {
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketDesc() {
        return ticketDesc;
    }

    public void setTicketDesc(String ticketDesc) {
        this.ticketDesc = ticketDesc;
    }

    public double getReimbAmount() {
        return reimbAmount;
    }

    public void setReimbAmount(double reimbAmount) {
        this.reimbAmount = reimbAmount;
    }



    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public void setResolveTime(Date resolveTime) {
        this.resolveTime = resolveTime;
    }

    public Date getResolveTime() {
        return resolveTime;
    }

    public ReimbursementType getType() {
        return type;
    }

    public void setType(ReimbursementType type) {
        this.type = type;
    }

    public ReimbursementStatus getStatus() {
        return status;
    }

    public void setStatus(ReimbursementStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                ", ticketId=" + ticketId +
                ", reimbAmount=" + reimbAmount +
                ", ticketDesc='" + ticketDesc + '\'' +
                ", employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", managerName='" + managerName + '\'' +
                ", submitTime=" + submitTime +
                ", resolveTime=" + resolveTime +
                ", type=" + type +
                ", status=" + status +
                '}';
    }

}
