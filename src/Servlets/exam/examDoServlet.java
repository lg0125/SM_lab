package Servlets.exam;

import DAOs.CourseDAO;
import DAOs.PublicDAO;
import Views.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/examDoServlet")
public class examDoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_info");
        String student_id = user.getId();
        String teacher_id = request.getParameter("teacher_id");
        String course_id = request.getParameter("course_id");

        int problem_num = Integer.parseInt(request.getParameter("problem_num"));
        PublicDAO public_dao = new PublicDAO();

        String submit;
        Integer problem_id;
        Integer submit_id;
        Double sum = 0.0;
        Double avg = 100.0/problem_num;
        for(int i = 1;i <= problem_num;i++){
            submit = request.getParameter("choose_"+i);
            problem_id = Integer.parseInt(submit.substring(0,submit.indexOf("ID")));
            submit_id = Integer.parseInt(submit.substring(submit.indexOf("ID")+2));
            if(public_dao.is_answer(problem_id,submit_id)){
                sum += avg;
            }
        }
        if(sum > 100) sum = 100.0;

        CourseDAO course_dao = new CourseDAO();
        course_dao.update(student_id,course_id,teacher_id,sum);

        request.setAttribute("score",sum);
        request.getRequestDispatcher("app/exam/result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
