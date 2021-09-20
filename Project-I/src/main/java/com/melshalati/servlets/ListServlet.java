package com.melshalati.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.melshalati.model.Employee;
import com.melshalati.model.Reimbursement;
import com.melshalati.service.EmployeeServiceAlpha;
import com.melshalati.service.ReimbursementServiceAlpha;
import com.melshalati.util.ConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List <Reimbursement> list = ReimbursementServiceAlpha.getInstance().selectAll();
        System.out.println(list);
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter out = response.getWriter();
        String usersJSON = mapper.writeValueAsString(list);
        out.write(usersJSON);
    }
}
