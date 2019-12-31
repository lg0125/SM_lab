package Servlets.student;

import DAOs.PublicDAO;
import Views.StudentGradeList;
import Views.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/transStudentGradeListServlet")
public class transStudentGradeListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_info");
        String student_id = user.getId();

        PublicDAO public_dao = new PublicDAO();
        ArrayList<StudentGradeList> student_grade_list = public_dao.query_studentGrade(student_id);

        request.setAttribute("student_grade_list",student_grade_list);
        request.getRequestDispatcher("app/student/gradeListShow.jsp").forward(request,response);
    }
}
