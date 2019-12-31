package Servlets.root;

import Beans.Course;
import DAOs.CourseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addCourseServlet")
public class addCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String course_id = request.getParameter("course_id");
        String course_name = request.getParameter("course_name");
        String introduction = request.getParameter("introduction");

        CourseDAO course_dao = new CourseDAO();
        course_dao.addCourse(course_id,course_name,introduction);

        List<Course> course_list = course_dao.query();
        request.setAttribute("course_list",course_list);
        request.getRequestDispatcher("app/root/addCourse.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
