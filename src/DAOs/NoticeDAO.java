package DAOs;

import Beans.Notice;

import java.util.ArrayList;

public class NoticeDAO extends BaseDAO {

    public ArrayList<Notice> query(){
        Class<Notice> clazz = Notice.class;
        String sql = "SELECT * FROM notice WHERE 1 ";
        Object[] param = {};
        return execute_Query(clazz,sql,0,param);
    }

    public Boolean add(String title,String content,String time,String teacher_id){
        String sql = "INSERT INTO notice (title,content,time,teacher_id) "
                    +"VALUES(?,?,?,?) ";
        Object[] param = {title,content,time,teacher_id};
        return execute_Statement(sql,param);
    }

    public Boolean delete(Integer id){
        String sql = "DELETE FROM notice WHERE id=? ";
        Object[] param = {id};
        return execute_Statement(sql,id);
    }

    public Boolean update_title(Integer id,String title){
        String sql = "UPDATE notice SET title=? WHERE id=? ";
        Object[] param = {title,id};
        return execute_Statement(sql,param);
    }

    public Boolean update_content(Integer id,String content){
        String sql = "UPDATE notice SET content=? WHERE id=? ";
        Object[] param = {content,id};
        return execute_Statement(sql,param);
    }

}
