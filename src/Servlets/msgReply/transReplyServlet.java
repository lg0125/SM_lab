package Servlets.msgReply;

import Beans.Reply;
import DAOs.ReplyDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transReplyServlet")
public class transReplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer reply_id = Integer.parseInt(request.getParameter("reply_id"));
        ReplyDAO reply_dao = new ReplyDAO();
        Reply reply = reply_dao.query(reply_id).get(0);
        request.setAttribute("Reply",reply);
        request.getRequestDispatcher("app/msgBoard/replyInfo.jsp").forward(request,response);
    }
}
