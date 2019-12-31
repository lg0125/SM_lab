package Servlets.teacher;

import Beans.Warning;
import DAOs.WarningDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/writeWarningServlet")
public class writeWarningServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String course_id = request.getParameter("course_id");
        String teacher_id = request.getParameter("teacher_id");
        String student_id = request.getParameter("student_id");
        //double grade = Double.parseDouble(request.getParameter("grade"));
        String grade = request.getParameter("grade");

        String title = "成绩预警----"+"课程:"+course_id;
        String content = "成绩预警----"+"课程:"+course_id+" 教师:"+teacher_id+" 分数:"+grade;
        Date time = new Date(new java.util.Date().getTime());

        Warning warning = new Warning();
        warning.setContent(content);
        warning.setTitle(title);
        warning.setTime(time);
        warning.setCourse_id(course_id);
        warning.setTeacher_id(teacher_id);
        warning.setStudent_id(student_id);

        WarningDAO warning_dao = new WarningDAO();
        warning_dao.add(warning);

        request.getRequestDispatcher("/scanWarningServlet").forward(request,response); //?
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
