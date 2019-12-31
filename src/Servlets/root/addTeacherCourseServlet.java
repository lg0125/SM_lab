package Servlets.root;

import Beans.Course;
import Beans.Teacher;
import DAOs.CourseDAO;
import DAOs.PublicDAO;
import DAOs.TeacherDAO;
import Views.TeacherCourse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/addTeacherCourseServlet")
public class addTeacherCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String course_id = request.getParameter("course_id");
        String teacher_id = request.getParameter("teacher_id");

        PublicDAO public_dao = new PublicDAO();
        TeacherDAO teacher_dao = new TeacherDAO();
        CourseDAO course_dao = new CourseDAO();

        public_dao.add_TeacherCourse(course_id,teacher_id);

        ArrayList<TeacherCourse> teacher_course_list = public_dao.query_TeacherCourse();
        ArrayList<Teacher> teacher_list = teacher_dao.query();
        ArrayList<Course> course_list = course_dao.query();

        request.setAttribute("course_list",course_list);
        request.setAttribute("teacher_list",teacher_list);
        request.setAttribute("teacher_course_list",teacher_course_list);
        request.getRequestDispatcher("app/root/addTeacherCourse.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
