package com.diary.controller;

import com.diary.model.Diary;
import com.diary.helper.Helper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteDiaryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int diaryId = Integer.parseInt(request.getParameter("diary_id"));
        Diary foundDiary = Helper.diaryRepository().get(diaryId);

        if (foundDiary != null) {
            Helper.diaryRepository().remove(diaryId);
        }

        response.sendRedirect("mydiaries");
    }
}
