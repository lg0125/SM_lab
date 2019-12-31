package Servlets.teacher;

import Beans.Reply;
import Beans.Teacher;
import DAOs.MessageDAO;
import DAOs.ReplyDAO;
import DAOs.TeacherDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/writeReplyServlet")
public class writeReplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacher_id = request.getParameter("teacher_id");
        Integer message_id = Integer.parseInt(request.getParameter("message_id"));

        TeacherDAO teacher_dao = new TeacherDAO();
        Teacher teacher = teacher_dao.query(teacher_id).get(0);
        String teacher_name = teacher.getName();

        String content = request.getParameter("content");
        Date time = new Date(new java.util.Date().getTime());


        Reply reply = new Reply();
        reply.setContent(content);
        reply.setMessage_id(message_id);
        reply.setTeacher_id(teacher_id);
        reply.setTeacher_name(teacher_name);
        reply.setTime(time);

        ReplyDAO reply_dao = new ReplyDAO();
        reply_dao.add(reply);
        MessageDAO message_dao = new MessageDAO();
        message_dao.updateStatus(message_id);

        request.getRequestDispatcher("/listNotRepliedMsgServlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

   /* private String set_time(){

        Calendar cal = Calendar.getInstance();

        int y=cal.get(Calendar.YEAR);

        int m=cal.get(Calendar.MONTH);

        int d=cal.get(Calendar.DATE);

        int h=cal.get(Calendar.HOUR_OF_DAY);

        int mi=cal.get(Calendar.MINUTE);

        int s=cal.get(Calendar.SECOND);

        return y+"-"+m+"-"+d+"-"+h+":"+mi+":"+s;

    }*/
}
