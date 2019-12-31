package Servlets.teacher;

import Beans.Message;
import DAOs.MessageDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transWriteReplyServlet")
public class transWriteReplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer message_id = Integer.parseInt(request.getParameter("message_id"));
        MessageDAO message_dao = new MessageDAO();
        Message message = message_dao.queryID(message_id).get(0);
        request.setAttribute("Message",message);
        request.getRequestDispatcher("app/teacher/writeReply.jsp").forward(request,response);
    }
}
