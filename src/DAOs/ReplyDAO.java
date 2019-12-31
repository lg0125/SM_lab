package DAOs;

import Beans.Reply;

import java.util.ArrayList;

public class ReplyDAO extends BaseDAO {

    public ArrayList<Reply> query_messageID(Integer message_id){

        Class<Reply> clazz = Reply.class;

        String sql = "SELECT * FROM reply WHERE message_id=? ";

        Object[] arg = {message_id};

        return execute_Query(clazz,sql,arg.length,arg);

    }

    public ArrayList<Reply> query(Integer id){

        Class<Reply> clazz = Reply.class;

        String sql = "SELECT * FROM reply WHERE id=? ";

        Object[] arg = {id};

        return execute_Query(clazz,sql,arg.length,arg);

    }

    public Boolean add(Reply reply){

        String sql = "INSERT INTO reply (content,time,teacher_id,teacher_name,message_id) "
                    +"VALUES (?,?,?,?,?) ";

        Object[] arg = {reply.getContent(),reply.getTime(),reply.getTeacher_id(),reply.getTeacher_name(),reply.getMessage_id()};

        return execute_Statement(sql,arg);

    }

    public Boolean delete(Integer id){

        String sql = "DELETE FROM reply WHERE id=? ";

        Object[] arg = {id};

        return execute_Statement(sql,arg);

    }

    public Boolean delete_messageID(Integer message_id){

        String sql = "DELETE FROM reply WHERE message_id=? ";

        Object[] arg = {message_id};

        return execute_Statement(sql,arg);

    }

    public Boolean update_content(String content,Integer id){

        String sql = "UPDATE reply SET content=? WHERE id=? ";

        Object[] arg = {content,id};

        return execute_Statement(sql,arg);

    }

    public Boolean updateTeacherPhoto(String teacher_id,String teacher_photo){

        String sql = "UPDATE reply SET teacher_photo=? WHERE teacher_id=? ";

        Object[] param = {teacher_photo,teacher_id};

        return execute_Statement(sql,param);

    }

    public Boolean updateTeacherId(String oldId,String newId){

        String sql = "UPDATE reply SET teacher_id=? WHERE teacher_id=? ";

        Object[] param = {newId,oldId};

        return execute_Statement(sql,param);

    }

}
