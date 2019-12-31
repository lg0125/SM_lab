package Servlets.root;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temp  = request.getParameter("fileName");
        String fileName = temp.substring(temp.indexOf("=")+1);
        String fileSaveRootPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        String path = findFileSavePathByFileName(fileName,fileSaveRootPath);
        File file = new File(path+"\\"+fileName);

        if(!file.exists()){
            request.setAttribute("message","你要下载的资源已经被删除");
            request.getRequestDispatcher("app/root/message.jsp").forward(request,response);
            return;
        }
        String realName = fileName.substring(fileName.indexOf("_")+1);
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(realName, StandardCharsets.UTF_8));
        FileInputStream in = new FileInputStream(path+"\\"+fileName);
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    private String findFileSavePathByFileName(String filename,String saveRootPath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode & 0xf;
        int dir2 = (hashcode & 0xf0) >> 4;
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;
        File file = new File(dir);
        if(!file.exists()){
            file.mkdirs();
        }
        return dir;
    }
}
