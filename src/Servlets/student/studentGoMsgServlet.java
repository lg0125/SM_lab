package Servlets.student;

import Beans.Message;
import DAOs.MessageDAO;
import DAOs.PublicDAO;
import Views.TeacherCourse;
import Views.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/studentGoMsgServlet")
public class studentGoMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_info");
        String student_id = user.getId();

        Integer notReply = 0;

        MessageDAO message_dao = new MessageDAO();

        ArrayList<Message> message_list = message_dao.query(notReply,student_id);

        int number = message_list.size();

        PublicDAO public_dao = new PublicDAO();

        ArrayList<TeacherCourse> teacher_course_list = public_dao.query_TeacherCourse();

        request.setAttribute("notReply",number);
        request.setAttribute("teacher_course_list",teacher_course_list);
        request.getRequestDispatcher("app/msgBoard/msgBoardContent.jsp").forward(request,response);
    }
}
