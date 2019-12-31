package Servlets.op;


import Beans.Student;
import DAOs.MessageDAO;
import DAOs.ReplyDAO;
import DAOs.StudentDAO;
import DAOs.TeacherDAO;
import Views.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@WebServlet("/UploadHeadServlet")
public class UploadHeadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String savePath = this.getServletContext().getRealPath("/upload");
        String tempPath = this.getServletContext().getRealPath("/temp");
        File tempFile = new File(tempPath);
        if(!tempFile.exists()) tempFile.mkdir();

        try{
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024*100);
            factory.setRepository(tempFile);
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setProgressListener(
                    new ProgressListener() {
                        @Override
                        public void update(long l, long l1, int i) {
                            System.out.println("文件大小为"+l1+",当前已处理"+l);
                        }
                    }
            );
            upload.setHeaderEncoding("UTF-8");
            if(!ServletFileUpload.isMultipartContent(request)) return;
            upload.setFileSizeMax(1024*1024*10);
            upload.setSizeMax(1024*1024*10*10);
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item:list){
                if(item.isFormField()){
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    System.out.println(name+"=="+value);
                }else{
                    String fileName = item.getName();
                    if(fileName == null || fileName.trim().equals("")) continue;
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                    String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
                    System.out.println("上传的文件的扩展名是:"+fileExtName);
                    InputStream in = item.getInputStream();
                    String saveFileName = makeFileName(fileName);
                    System.out.println(saveFileName);
                    String realSavePath = makePath(saveFileName,savePath); //KEY
                    updatePhoto(request,realSavePath,saveFileName);
                    FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFileName);
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while((len = in.read(buffer)) > 0){
                        out.write(buffer,0,len);
                    }
                    in.close();
                    out.close();
                }
            }
        }catch (FileUploadBase.FileSizeLimitExceededException e){
            e.printStackTrace();
            request.setAttribute("message","单个文件超出最大值");
            request.getRequestDispatcher("app/role/upload.jsp").forward(request,response);
            return;
        }catch (FileUploadBase.SizeLimitExceededException ex){
            ex.printStackTrace();
            request.setAttribute("message","上传文件总的大小超出限制的最大值");
            request.getRequestDispatcher("app/role/upload.jsp").forward(request,response);
            return;
        }catch (Exception e){

            e.printStackTrace();
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private String makeFileName(String fileName){
        return UUID.randomUUID().toString()+"_"+fileName;
    }

    private String makePath(String fileName,String savePath){
        int hashCode = fileName.hashCode();
        int dir1 = hashCode & 0xf;
        int dir2 = (hashCode & 0xf0) >> 4;
        String dir = savePath + "\\" + dir1 + "\\" + dir2;
        File file = new File(dir);
        if(!file.exists()) file.mkdirs();
        return dir;
    }

    private void updatePhoto(HttpServletRequest request,String realSavePath,String saveFileName){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_info");
        String id = user.getId();
        String type = user.getType();

        String path = realSavePath + "\\" + saveFileName;
        String photo = path.substring(path.lastIndexOf("\\upload"));
        if(type.equals("student")){
            MessageDAO message_dao = new MessageDAO();
            StudentDAO student_dao = new StudentDAO();
            message_dao.updateStudentPhoto(id,photo);
            student_dao.updatePhoto(id,photo);
        }else{
            ReplyDAO reply_dao = new ReplyDAO();
            TeacherDAO teacher_dao = new TeacherDAO();
            reply_dao.updateTeacherPhoto(id,photo);
            teacher_dao.updatePhoto(id,photo);
        }
    }

}
