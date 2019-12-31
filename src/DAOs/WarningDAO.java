package DAOs;

import Beans.Warning;

import java.util.ArrayList;

public class WarningDAO extends BaseDAO {

    public Boolean add(Warning warning){

        String sql = "INSERT INTO warning (title,content,time,course_id,teacher_id,student_id) "
                    +"VALUES (?,?,?,?,?,?)";

        Object[] param = {warning.getTitle(),warning.getContent(),warning.getTime(),warning.getCourse_id(),warning.getTeacher_id(),warning.getStudent_id()};

        return execute_Statement(sql,param);

    }

    public ArrayList<Warning> queryStudent(String student_id){
        Class<Warning> clazz = Warning.class;

        String sql = "SELECT * FROM warning WHERE student_id=? ";

        Object[] param = {student_id};

        return execute_Query(clazz,sql,param.length,param);
    }

    public ArrayList<Warning> queryTeacher(String teacher_id){

        Class<Warning> clazz = Warning.class;

        String sql = "SELECT * FROM warning WHERE teacher_id=? ";

        Object[] param = {teacher_id};

        return execute_Query(clazz,sql,param.length,param);

    }

}
