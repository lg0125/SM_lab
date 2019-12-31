package Servlets.teacher;

import DAOs.PublicDAO;
import Views.CourseGradeList;
import Views.TeacherCourse;
import Views.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/courseGradeListServlet")
public class courseGradeListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user_info");

        String teacher_id = user.getId();

        String course_id = request.getParameter("course_id");

        PublicDAO public_dao = new PublicDAO();

        ArrayList<CourseGradeList> course_grade_list = public_dao.query_courseGrade(course_id,teacher_id);

        request.setAttribute("course_grade_list",course_grade_list);

        request.getRequestDispatcher("app/teacher/courseGrade.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
