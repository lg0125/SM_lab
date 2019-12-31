package Servlets.student;

import Beans.Warning;
import DAOs.WarningDAO;
import Views.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/scanWarningStudentServlet")
public class scanWarningStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_info");
        String student_id = user.getId();

        WarningDAO warning_dao = new WarningDAO();
        ArrayList<Warning> student_warning = warning_dao.queryStudent(student_id);

        request.setAttribute("student_warning",student_warning);
        request.getRequestDispatcher("app/student/scanWarning.jsp").forward(request,response);
    }
}
