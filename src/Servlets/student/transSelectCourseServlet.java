package Servlets.student;

import Beans.Student;
import DAOs.PublicDAO;
import Views.SelectCourseList;
import Views.StudentCourseList;
import Views.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/transSelectCourseServlet")
public class transSelectCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_info");
        String student_id = user.getId();

        PublicDAO public_dao = new PublicDAO();
        ArrayList<SelectCourseList> select_course_list = public_dao.query_SelectCourse(student_id);
        ArrayList<StudentCourseList> student_course_list = public_dao.query_studentCourse(student_id);

        request.setAttribute("select_course_list",select_course_list);
        request.setAttribute("student_course_list",student_course_list);
        request.getRequestDispatcher("app/student/selectCourse.jsp").forward(request,response);
    }
}
