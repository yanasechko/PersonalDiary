package com.diary.controller;

import com.diary.model.Diary;
import com.diary.model.User;
import com.diary.helper.Helper;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddDiaryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("viewFile", "add.jsp");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        request.setAttribute("pageTitle", "Добавить новую запись / "
                + sdf.format(new Date()));
        Helper.view(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User loginUser = Helper.getLoginUser(request);
        String diaryContent = request.getParameter("diaryContent");
        boolean visible = request.getParameter("visible") != null;

        Diary newDiary = new Diary();
        newDiary.setUserId(loginUser.getId());
        newDiary.setDateOfDiary(new Date());
        newDiary.setContent(diaryContent);
        newDiary.setVisibility(visible);

        boolean addResult = Helper.diaryRepository().add(newDiary);
        if (!addResult) {
            request.setAttribute("viewFile", "add.jsp");
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            request.setAttribute("pageTitle", "Добавьте новую запись / "
                    + sdf.format(new Date()));
            request.setAttribute("message", "Что-то пошло не так...");
            Helper.view(request, response);
        } else {
            response.sendRedirect("mydiaries");
        }

    }
}
