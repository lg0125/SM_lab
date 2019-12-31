package Servlets.teacher;

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

@WebServlet("/transStudentGradeWarningServlet")
public class transStudentGradeWarningServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_info");
        String teacher_id = user.getId();

        PublicDAO public_dao = new PublicDAO();
        ArrayList<StudentGradeList> studentGrade_warning_list = public_dao.query_StudentGradeWarning(teacher_id);
        request.setAttribute("studentGrade_warning_list",studentGrade_warning_list);
        request.getRequestDispatcher("app/teacher/warningContent.jsp").forward(request,response);
    }
}
