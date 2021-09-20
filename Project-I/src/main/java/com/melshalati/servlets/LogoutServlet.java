package com.melshalati.servlets;

import com.melshalati.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Cookie[] cookies = request.getCookies();
//        System.out.println(cookies[0].getValue());
//        for (int i = 0; i < cookies.length; i++){
//            cookies[i].setValue("");
//        }
//        System.out.println(cookies[0].getValue());

//        request.getRequestDispatcher("login.html").forward(request, response);
        response.sendRedirect("login.html");
    }
}
