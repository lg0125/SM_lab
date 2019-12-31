package Servlets.root;

import Beans.Teacher;
import DAOs.StudentDAO;
import DAOs.TeacherDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/signUpServlet")
public class signUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        if(type.equals("teacher")){
            String rank_name = request.getParameter("rank_name");
            if(rank_name == null) rank_name = "";
            String introduction = request.getParameter("introduction");
            TeacherDAO teacher_dao = new TeacherDAO();
            teacher_dao.add(id,password,name,rank_name,introduction);
            List<Teacher> teacher_list = teacher_dao.query();
            request.setAttribute("teacher_list",teacher_list);
            request.getRequestDispatcher("/app/include/teacherSignUp.jsp").forward(request,response);

        }else{
            StudentDAO student_dao = new StudentDAO();
            student_dao.add(id,password,name);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
