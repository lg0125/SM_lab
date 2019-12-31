package Servlets.root;

import Beans.Course;
import DAOs.CourseDAO;
import DAOs.PublicDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/deleteCourseServlet")
public class deleteCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        String course_id = request.getParameter("course_id");
        CourseDAO course_dao = new CourseDAO();
        if(course_dao.query(course_id).size() > 0){
            PublicDAO public_dao = new PublicDAO();
            Boolean op1 = public_dao.delete_takes(course_id);
            Boolean op2 = public_dao.delete_teaches(course_id);
            Boolean op3 = course_dao.delete_id(course_id);
            if(op1 && op2 && op3) message = "删除课程成功";
            else message = "删除课程失败";
        }else{
            message = "找不到course_id对应的课程,无法进行删除操作";
        }
        ArrayList<Course> course_list = course_dao.query();

        request.setAttribute("message",message);
        request.setAttribute("course_list",course_list);
        request.getRequestDispatcher("app/root/deleteCourse.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
