package Servlets.root;

import Beans.Teacher;
import DAOs.CourseDAO;
import DAOs.PublicDAO;
import DAOs.StudentDAO;
import DAOs.TeacherDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeInfoServlet")
public class changeInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        String old_id = request.getParameter("old_id");
        String new_id = request.getParameter("new_id");
        String old_password = request.getParameter("old_password");
        String new_password = request.getParameter("new_password");

        PublicDAO public_dao = new PublicDAO();

        if(new_id.equals("") && new_password.equals("")) {
            request.getRequestDispatcher("app/root/rootMessage.jsp").forward(request,response);
        }else{
            if(new_id.equals("")) new_id = old_id;
            if(new_password.equals("")) new_password = old_password;

            if(type.equals("root")){
                if(public_dao.signIn_query(old_id,old_password).size() > 0){
                    public_dao.changeInfo(old_id,new_id,new_password);
                }
            }
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
