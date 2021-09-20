package com.melshalati.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.melshalati.model.Employee;
import com.melshalati.model.enums.EmployeeRole;
import com.melshalati.repository.EmployeeRepoJdbc;
import com.melshalati.service.EmployeeServiceAlpha;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String[] credentials = null;
        Employee loggedEmployee = new Employee();
        ObjectMapper mapper = new ObjectMapper();
        credentials = mapper.readValue(request.getInputStream(), String[].class);
        System.out.println(credentials[0] +" "+ credentials[1]);
        loggedEmployee.setEmail(credentials[0]);
        loggedEmployee.setEmpPassword(credentials[1]);
        loggedEmployee = EmployeeServiceAlpha.getInstance().authenticate(loggedEmployee);



        if (loggedEmployee == null){
            response.setStatus(401);
        }
        else{
            Cookie cookie = new Cookie("userId", loggedEmployee.getEmpID()+"");
            if (loggedEmployee.getRole().equals(EmployeeRole.MANAGER)){
                System.out.println("is manager");
                session.setAttribute("user", loggedEmployee);
                Cookie cki = new Cookie("isManager", "true");
                response.addCookie(cki);
            }
            else {
                Cookie cki = new Cookie("isManager", "false");
                response.addCookie(cki);
                session.setAttribute("user", loggedEmployee);
            }
            response.addCookie(cookie);
            response.sendRedirect("list.html");
        }

    }
}
