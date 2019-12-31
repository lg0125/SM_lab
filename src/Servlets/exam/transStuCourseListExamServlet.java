package Servlets.exam;

import DAOs.PublicDAO;
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

@WebServlet("/transStuCourseExamServlet")
public class transStuCourseListExamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_info");

        String message = "";
        PublicDAO public_dao = new PublicDAO();
        ArrayList<StudentCourseList> student_course_list = public_dao.query_studentCourse(user.getId());

        if(student_course_list == null) message = "该学员无选课列表";

        request.setAttribute("message",message);
        request.setAttribute("student_course_list",student_course_list);
        request.getRequestDispatcher("app/exam/examContent.jsp").forward(request,response);
    }
}
