package Servlets.student;

import Beans.Message;
import Beans.Student;
import DAOs.MessageDAO;
import DAOs.PublicDAO;
import DAOs.StudentDAO;
import Views.StudentCourseList;
import Views.TeacherCourse;
import Views.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

@WebServlet("/writeMsgServlet")
public class writeMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_info");

        String student_id = user.getId();
        StudentDAO student_dao = new StudentDAO();
        ArrayList<Student> temp = student_dao.query(student_id);
        Student student = temp.get(0);
        String student_name = student.getName();

        String course_id = request.getParameter("course_id");
        String teacher_id = request.getParameter("teacher_id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Date time = new Date(new java.util.Date().getTime());
        Integer status = 0;

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        message.setTime(time);
        message.setStudent_id(student_id);
        message.setStudent_name(student_name);
        message.setCourse_id(course_id);
        message.setTeacher_id(teacher_id);
        message.setStatus(status);

        MessageDAO message_dao = new MessageDAO();
        message_dao.add(message);

        PublicDAO public_dao = new PublicDAO();
        ArrayList<StudentCourseList> student_course_list = public_dao.query_studentCourse(student_id);
        request.setAttribute("student_course_list",student_course_list);
        request.getRequestDispatcher("app/student/listWriteMsg.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
