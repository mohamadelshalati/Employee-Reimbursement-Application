package com.melshalati.servlets;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.melshalati.model.Employee;
import com.melshalati.model.Reimbursement;
import com.melshalati.model.enums.ReimbursementStatus;
import com.melshalati.model.enums.ReimbursementType;
import com.melshalati.service.EmployeeServiceAlpha;
import com.melshalati.service.ReimbursementServiceAlpha;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Date;


@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] form;
        ObjectMapper mapper = new ObjectMapper();
        form = mapper.readValue(request.getInputStream(), String[].class);
        System.out.println("id " + Double.parseDouble(form[0]));
        System.out.println(form[0] +" "+ form[1] +" "+form[2]);

        Employee employee = new Employee();
        HttpSession session = request.getSession();
        employee = (Employee) session.getAttribute("user");

        Employee loggedEmployee = EmployeeServiceAlpha.getInstance().select(employee);

        String type = null;
        if (form[1].equals("1")){
            form[1] = "LODGING";
        }
        else if(form[1].equals("2")) {
            form[1] = "TRAVEL";
        }
        else if (form[1].equals("3")){
            form[1] = "FOOD";
        }
        else {
            form[1] = "OTHER";
        }

        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setReimbAmount(Double.parseDouble(form[0]));
        reimbursement.setType(ReimbursementType.valueOf(form[1]));
        reimbursement.setTicketDesc(form[2]);
        reimbursement.setEmployeeName(loggedEmployee.getFirstName()+" "+loggedEmployee.getLastname());
        reimbursement.setEmployeeID(loggedEmployee.getEmpID());
        reimbursement.setSubmitTime(new Date());
        reimbursement.setStatus(ReimbursementStatus.PENDING);
        ReimbursementServiceAlpha.getInstance().insert(reimbursement);

        response.sendRedirect("list.html");
    }
}
