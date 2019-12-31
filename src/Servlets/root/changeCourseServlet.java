package Servlets.root;

import Beans.Course;
import DAOs.CourseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/changeCourseServlet")
public class changeCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String course_id = request.getParameter("course_id");
        String course_name = request.getParameter("course_name");
        String introduction = request.getParameter("introduction");
        String course_new_id = request.getParameter("course_new_id");

        String message = "";
        CourseDAO course_dao = new CourseDAO();
        if(course_id.equals("") ){
            message = "course_id不能为空,请重新填写";
        }else{
            if(!course_name.equals("")){
                if(course_dao.update_name(course_id,course_name)){
                    message += "course_name修改成功;";
                }else{
                    message += "course_name修改失败;";
                }
            }
            if(!introduction.equals("")){
                if(course_dao.update_introduction(course_id,introduction)){
                    message += "introduction修改成功;";
                }else{
                    message += "introduction修改成功;";
                }
            }
            if(!course_new_id.equals("")){
                if(course_dao.update_id(course_id,course_new_id)){
                    message += "course_id修改成功";
                }else{
                    message += "course_id修改失败";
                }
            }
        }
        ArrayList<Course> course_list = course_dao.query();

        request.setAttribute("message",message);
        request.setAttribute("course_list",course_list);
        request.getRequestDispatcher("app/root/changeCourse.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
