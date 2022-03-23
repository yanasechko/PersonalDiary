package com.diary.controller;

import com.diary.model.User;
import com.diary.helper.Helper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("viewFile", "register.jsp");
        request.setAttribute("pageTitle", "Регистрация");
        Helper.view(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] parameters = {"first_name", "last_name", "email", "password"};
        boolean checkResult = Helper
                .checkParameters(parameters, request.getParameterMap());

        if (!checkResult) {
            request.setAttribute("viewFile", "register.jsp");
            request.setAttribute("message", "Пожалуйста, заполните все поля.");
            Helper.view(request, response);
        } else {

            String fistName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User newUser = new User();
            newUser.setFirstName(fistName);
            newUser.setLastName(lastName);
            newUser.setEmail(email);
            newUser.setPassword(Helper.md5(password));

            boolean registerResult = Helper.userRepository().add(newUser);
            if (registerResult) {
                response.sendRedirect("login");
            } else {
                request.setAttribute("message", "Что-то пошло не так...");
                request.setAttribute("viewFile", "register.jsp");
                request.setAttribute("pageTitle", "Регистрация");
                Helper.view(request, response);
            }
        }

    }
}
