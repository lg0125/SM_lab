package Servlets.student;

import Beans.Message;
import Beans.Reply;
import DAOs.MessageDAO;
import DAOs.ReplyDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/scanMsgSearchServlet")
public class scanMsgSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String student_name = request.getParameter("student_name");

        MessageDAO message_dao = new MessageDAO();
        ReplyDAO reply_dao = new ReplyDAO();

        ArrayList<Message> message_list = message_dao.query(title,content,student_name);
        HashMap<Long,ArrayList<Reply> > reply_map = new HashMap<>();

        for(Message message:message_list){
            Integer message_id = message.getId();
            ArrayList<Reply> reply_list = reply_dao.query_messageID(message_id);
            reply_map.put(message_id.longValue(),reply_list);
        }

        request.setAttribute("message_list",message_list);
        request.setAttribute("reply_map",reply_map);
        request.getRequestDispatcher("app/student/scanMsgReply.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
