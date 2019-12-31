package Servlets.msgReply;

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

@WebServlet("/changeMsgServlet")
public class changeMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Integer message_id = Integer.parseInt(request.getParameter("message_id"));

        MessageDAO message_dao = new MessageDAO();
        message_dao.update_title(title,message_id);
        message_dao.update_content(content,message_id);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_info");
        String id = user.getId();
        Integer notReply = 0;

        PublicDAO public_dao = new PublicDAO();
        ArrayList<TeacherCourse> teacher_course_list = null;
        ArrayList<Message> message_list = null;
        if(user.getType().equals("student")){
            message_list = message_dao.query(notReply,id);
            teacher_course_list = public_dao.query_TeacherCourse();
        }else{
            message_list = message_dao.query(id,notReply);
            teacher_course_list = public_dao.query_TeacherCourse(id);
        }

        int number = message_list.size();

        request.setAttribute("notReply",number);
        request.setAttribute("teacher_course_list",teacher_course_list);
        request.getRequestDispatcher("app/msgBoard/msgBoardContent.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
