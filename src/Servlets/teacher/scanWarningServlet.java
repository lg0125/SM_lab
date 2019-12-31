package Servlets.teacher;

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

@WebServlet("/scanWarningServlet")
public class scanWarningServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_info");
        String teacher_id = user.getId();

        WarningDAO warning_dao = new WarningDAO();
        ArrayList<Warning> teacher_warning = warning_dao.queryTeacher(teacher_id);

        request.setAttribute("teacher_warning",teacher_warning);
        request.getRequestDispatcher("app/teacher/scanWarning.jsp").forward(request,response);
    }
}
