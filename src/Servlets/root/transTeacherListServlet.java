package Servlets.root;

import Beans.Teacher;
import DAOs.TeacherDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/transTeacherListServlet")
public class transTeacherListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherDAO teacher_dao = new TeacherDAO();
        ArrayList<Teacher> teacher_list =teacher_dao.query();
        request.setAttribute("teacher_list",teacher_list);
        request.getRequestDispatcher("app/root/teacherShow.jsp").forward(request,response);
    }
}
