package com.diary.controller;

import com.diary.model.Diary;
import com.diary.helper.Helper;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditDiaryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int diaryId = Integer.parseInt(request.getParameter("diary_id"));
        Diary foundDiary = Helper.diaryRepository().get(diaryId);

        if (foundDiary != null) {
            request.setAttribute("viewFile", "edit.jsp");
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            request.setAttribute("pageTitle", "Изменить запись / "
                    + sdf.format(foundDiary.getDateOfDiary()));
            request.setAttribute("diary", foundDiary);
            Helper.view(request, response);
        } else {
            response.sendRedirect("mydiaries");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int diaryId = Integer.parseInt(request.getParameter("diary_id"));
        Diary foundDiary = Helper.diaryRepository().get(diaryId);

        if (foundDiary != null) {
            String diaryContent = request.getParameter("diaryContent");
            boolean visible = request.getParameter("visible") != null;
            foundDiary.setContent(diaryContent);
            foundDiary.setVisibility(visible);

            Diary editResult = Helper.diaryRepository()
                    .update(foundDiary.getId(), foundDiary);

            if (editResult != null) {
                response.sendRedirect("mydiaries");
            } else {
                request.setAttribute("viewFile", "edit.jsp");
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                request.setAttribute("pageTitle", "Добавить новую запись / "
                        + sdf.format(foundDiary.getDateOfDiary()));
                request.setAttribute("message", "Что-то пошло не так...");
                Helper.view(request, response);
            }
        } else {
            response.sendRedirect("mydiaries");
        }

    }
}
