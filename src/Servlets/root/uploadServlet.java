package Servlets.root;

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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@WebServlet("/uploadServlet")
public class uploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";

        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        //System.out.println(savePath);
        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        //System.out.println(tempPath);
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
                        public void update(long pBytesRead,long pContentLength,int arg2) {
                            System.out.println("文件大小为:"+pContentLength+",当前已处理:"+pBytesRead);
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
                    //System.out.println(name+"=="+value);
                }else{
                    String fileName = item.getName();
                    //System.out.println(fileName);
                    if(fileName == null || fileName.trim().equals("")) continue;
                    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
                    String fileExtName = fileName.substring(fileName.lastIndexOf(".")+1);
                    //System.out.println("上传的文件的扩展名是:"+fileExtName);
                    InputStream in = item.getInputStream();
                    String saveFileName = makeFileName(fileName);
                    String realSavePath = makePath(saveFileName,savePath);
                    FileOutputStream out = new FileOutputStream(realSavePath+"\\"+saveFileName);
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while((len=in.read(buffer))>0){
                        out.write(buffer,0,len);
                    }
                    in.close();
                    out.close();
                    message = "文件上传成功";
                }
            }
        }catch (FileUploadBase.FileSizeLimitExceededException e){
            e.printStackTrace();
            request.setAttribute("message","单个文件超出最大值");
            request.getRequestDispatcher("app/root/message.jsp").forward(request,response);
            return;
        }catch (FileUploadBase.SizeLimitExceededException ex){
            ex.printStackTrace();
            request.setAttribute("message","上传文件总的大小超出限制的最大值");
            request.getRequestDispatcher("app/root/message.jsp").forward(request,response);
            return;
        }catch (Exception e){
            message = "文件上传失败";
            e.printStackTrace();
        }
        request.setAttribute("message",message);
        request.getRequestDispatcher("app/root/message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private String makeFileName(String filename){
        return UUID.randomUUID().toString()+"_"+filename;
    }

    private String makePath(String filename,String savePath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode & 0xf;
        int dir2 = (hashcode & 0xf0) >> 4;
        String dir = savePath+"\\"+dir1+"\\"+dir2;
        File file = new File(dir);
        if(!file.exists()) file.mkdirs();
        return dir;
    }
}
