package Servlets.exam;

import DAOs.PublicDAO;
import Views.Problem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/examServlet")
public class examServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String course_id = request.getParameter("course_id");

        String teacher_id = request.getParameter("teacher_id");


        PublicDAO public_dao = new PublicDAO();

        ArrayList<Problem> problem_list = public_dao.query_Problem(course_id);

        int problem_num = problem_list.size();


        if(problem_num > 5 && (100 % problem_num != 0)) problem_num = 5;

        request.setAttribute("problem_list",problem_list);

        request.setAttribute("problem_num",problem_num);

        request.setAttribute("course_id",course_id);
        request.setAttribute("teacher_id",teacher_id);

        request.getRequestDispatcher("app/exam/examDo.jsp").forward(request,response);
    }
}
