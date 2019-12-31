package Servlets.op;

import DAOs.PublicDAO;
import DataOp.ExcelOP;
import Views.StudentCourseList;
import Views.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

@WebServlet("/ExcelServlet")
public class ExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user_info");
            String student_id = user.getId();

            PublicDAO public_dao = new PublicDAO();
            ArrayList fieldData = public_dao.query_studentCourse(student_id);

            Class clazz = StudentCourseList.class;
            Field[] fields = clazz.getFields();
            ArrayList fieldName = new ArrayList();
            for (Field field : fields) {
                fieldName.add(field.getName());
            }

            OutputStream out = response.getOutputStream();

            response.reset();

            String excel = "Student" + student_id + "CourseExcel";

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + excel + ".xls");

            ExcelOP excelOP = new ExcelOP(fieldName, fieldData);

            excelOP.exportExcel(out);

            System.setOut(new PrintStream(out));

            out.flush();

            out.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
