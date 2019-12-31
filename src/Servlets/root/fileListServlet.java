package Servlets.root;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/fileListServlet")
public class fileListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        System.out.println(uploadFilePath);
        Map<String,String> fileNameMap = new HashMap<>();
        listFile(new File(uploadFilePath),fileNameMap);
        request.setAttribute("fileNameMap",fileNameMap);
        request.getRequestDispatcher("app/root/listFile.jsp").forward(request,response);
    }

    private void listFile(File file,Map<String,String>map){
        if(!file.isFile()){
            File[] files = file.listFiles();
            assert files != null;
            for(File f : files){
                listFile(f,map);
            }
        }else{
            String realName = file.getName().substring(file.getName().indexOf("_")+1);
            map.put(file.getName(),realName);
        }
    }
}
