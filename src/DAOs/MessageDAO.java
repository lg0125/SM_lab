package DAOs;

import Beans.Message;

import java.util.ArrayList;

public class MessageDAO extends BaseDAO {

    public ArrayList<Message> query(){

        Class<Message> clazz = Message.class;

        String sql = "SELECT * FROM message ";

        Object[] param = {};

        return execute_Query(clazz,sql,param.length,param);

    }

    public ArrayList<Message> query(String course_id,String teacher_id){

        Class<Message> clazz = Message.class;

        String sql = "SELECT * FROM message WHERE course_id=? AND teacher_id=? ";

        Object[] param = {course_id,teacher_id};

        return execute_Query(clazz,sql,param.length,param);

    }

    public ArrayList<Message> queryID(Integer id){

        Class<Message> clazz = Message.class;

        String sql = "SELECT * FROM message WHERE id=? ";

        Object[] param = {id};

        return execute_Query(clazz,sql,param.length,param);

    }


    public ArrayList<Message> query(String teacher_id,Integer status){
        Class<Message> clazz = Message.class;

        String sql = "SELECT * FROM message WHERE teacher_id=? AND status=? ";

        Object[] param = {teacher_id,status};

        return execute_Query(clazz,sql,param.length,param);
    }

    public ArrayList<Message> query(Integer status,String student_id){

        Class<Message> clazz = Message.class;

        String sql = "SELECT * FROM message WHERE status=? AND student_id=? ";

        Object[] param = {status,student_id};

        return execute_Query(clazz,sql,param.length,param);

    }

    public ArrayList<Message> query(String title,String content,String student_name){

        Class<Message> clazz = Message.class;

        String sql = "SELECT * FROM message WHERE 1 ";

        String sql_title = " and 1 " ;
        String sql_content = " and 1 ";
        String sql_name = " and 1 ";

        int i = 0;
        Object[] param = new Object[3];

        if(!title.equals("")){
            sql_title = "and title like ? ";
            param[i] = "%"+title+"%";
            i++;
        }
        if(!content.equals("")){
            sql_content = " and content like ? ";
            param[i] = "%"+content+"%";
            i++;
        }
        if(!student_name.equals("")){
            sql_name = " and student_name like ?";
            param[i] = "%"+student_name+"%";
            i++;
        }

        sql += sql_title + sql_content + sql_name;

        return execute_Query(clazz,sql,i,param);

    }

    public ArrayList<Message> queryStudentId(String student_id){
        Class<Message> clazz = Message.class;
        String sql = "SELECT * FROM message WHERE student_id=? ";
        Object[] param = {student_id};
        return execute_Query(clazz,sql,param.length,param);
    }

    public Boolean add(Message message){

        String sql = "INSERT INTO message (title,content,time,student_id,student_name,course_id,teacher_id,status) "
                    +"VALUES(?,?,?,?,?,?,?,?) ";

        Object[] param = {message.getTitle(),message.getContent(),message.getTime(),message.getStudent_id(),message.getStudent_name(),message.getCourse_id(),message.getTeacher_id(),message.getStatus()};

        return execute_Statement(sql,param);

    }

    public Boolean update_title(String title,Integer id){

        String sql = "UPDATE message SET title=? WHERE id=? ";

        Object[] arg = {title,id};

        return execute_Statement(sql,arg);

    }

    public Boolean update_content(String content,Integer id){

        String sql = "UPDATE message SET content=? WHERE id=? ";

        Object[] arg = {content,id};

        return execute_Statement(sql,arg);

    }

    public Boolean delete(Integer id){

        String sql = "DELETE FROM message WHERE id=? ";

        Object[] arg = {id};

        return execute_Statement(sql,arg);

    }

    public Boolean updateStudentPhoto(String student_id,String student_photo){

        String sql = "UPDATE message SET student_photo=? WHERE student_id=? ";

        Object[] param = {student_photo,student_id};

        return execute_Statement(sql,param);

    }

    public Boolean updateStudentId(String oldId,String newId){

        String sql = "UPDATE message SET student_id=? WHERE student_id=? ";

        Object[] param = {newId,oldId};

        return execute_Statement(sql,param);

    }

    public Boolean updateStatus(Integer id){

        String sql = "UPDATE message SET status=1 WHERE id=? ";

        Object[] param = {id};

        return execute_Statement(sql,param);

    }

}
