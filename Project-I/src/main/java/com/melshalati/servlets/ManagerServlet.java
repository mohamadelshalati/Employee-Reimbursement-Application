package com.melshalati.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.melshalati.model.Employee;
import com.melshalati.model.Reimbursement;
import com.melshalati.model.enums.ReimbursementStatus;
import com.melshalati.service.EmployeeServiceAlpha;
import com.melshalati.service.ReimbursementServiceAlpha;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee employee= new Employee();
        HttpSession session = request.getSession();
        employee = (Employee) session.getAttribute("user");
        Employee loggedEmployee = EmployeeServiceAlpha.getInstance().select(employee);
        System.out.println(loggedEmployee);

        int id = Integer.parseInt(request.getParameter("id"));
        String approved = request.getParameter("approve");
        System.out.println(approved);
        if (approved.equals("true")){
            Reimbursement reimbursement = new Reimbursement();
            reimbursement.setTicketId(id);
            Reimbursement reimbursementTicket = ReimbursementServiceAlpha.getInstance().select(reimbursement);
            reimbursementTicket.setStatus(ReimbursementStatus.APPROVED);
            reimbursementTicket.setManagerName(loggedEmployee.getFirstName()+" "+loggedEmployee.getLastname());
            reimbursementTicket.setResolveTime(new Date());
            ReimbursementServiceAlpha.getInstance().update(reimbursementTicket);

        }
        else {
            Reimbursement reimbursement = new Reimbursement();
            reimbursement.setTicketId(id);
            Reimbursement reimbursementTicket = ReimbursementServiceAlpha.getInstance().select(reimbursement);
            reimbursementTicket.setStatus(ReimbursementStatus.DENIED);
            reimbursementTicket.setManagerName(loggedEmployee.getFirstName()+" "+loggedEmployee.getLastname());
            reimbursementTicket.setResolveTime(new Date());
            ReimbursementServiceAlpha.getInstance().update(reimbursementTicket);


        }
        Cookie cookie = new Cookie("resolved", "true");
        response.addCookie(cookie);
        response.sendRedirect("managerList.html");
    }
}
