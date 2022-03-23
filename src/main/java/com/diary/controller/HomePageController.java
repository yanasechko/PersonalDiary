package com.diary.controller;

import com.diary.helper.Helper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("viewFile", "index.jsp");
        request.setAttribute("pageTitle", "Добро пожаловать!");
        request.setAttribute("diaryList", Helper.diaryRepository().getAll());
        request.setAttribute("userList", Helper.userRepository().getAll());
        Helper.view(request, response);
    }

}
