package com.melshalati.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.melshalati.model.Employee;
import com.melshalati.model.Reimbursement;
import com.melshalati.service.EmployeeServiceAlpha;
import com.melshalati.service.ReimbursementServiceAlpha;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/MyListServlet")
public class MyListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee loggedEmployee = null;
        HttpSession session = request.getSession();
        loggedEmployee = (Employee) session.getAttribute("user");
        System.out.println("**************");
        System.out.println(loggedEmployee);
        System.out.println("**************");
        List<Reimbursement> list = ReimbursementServiceAlpha.getInstance().selectAllEmpReimbursements(loggedEmployee);
        System.out.println(list);
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter out = response.getWriter();
        String usersJSON = mapper.writeValueAsString(list);
        out.write(usersJSON);
    }
}
