package com.diary.controller;

import com.diary.model.User;
import com.diary.helper.Helper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MydiariesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User loginUser = Helper.getLoginUser(request);
        request.setAttribute("viewFile", "mydiaries.jsp");
        request.setAttribute("pageTitle", "Мои записи:");
        request.setAttribute("diaryList", Helper.diaryRepository()
                .getAllByUserId(loginUser.getId(), true));
        Helper.view(request, response);
    }
}
