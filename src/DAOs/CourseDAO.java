package DAOs;

import Beans.Course;

import java.util.ArrayList;

public class CourseDAO extends BaseDAO {

    public Boolean addCourse(String id,String name,String introduction){

        String sql = "INSERT INTO course (id,name,introduction) "
                    +"VALUES (?,?,?) ";

        Object[] param = {id,name,introduction};

        return execute_Statement(sql,param);

    }

    public ArrayList<Course> query(){

        Class<Course> clazz = Course.class;

        String sql = "SELECT * FROM course ";

        Object[] param = {};

        return execute_Query(clazz,sql,0,param);

    }

    public ArrayList<Course> query(String id){

        Class<Course> clazz = Course.class;

        String sql = "SELECT * FROM course  WHERE id=? ";

        Object[] param = {id};

        return execute_Query(clazz,sql,param.length,param);

    }


    public Boolean update_name(String id,String name){

        String sql = "UPDATE course SET name=? WHERE id=? ";

        Object[] param = {name,id};

        return execute_Statement(sql,param);

    }

    public Boolean update_introduction(String id,String introduction){

        String sql = "UPDATE course SET introduction=? WHERE id=? ";

        Object[] param = {introduction,id};

        return execute_Statement(sql,param);

    }

    public Boolean update_id(String old_id,String new_id){

        String sql = "UPDATE course SET id=? WHERE id=? ";

        Object[] param = {new_id,old_id};

        return execute_Statement(sql,param);

    }

    public Boolean delete_id(String id){

        String sql = "DELETE FROM course WHERE id=? ";

        Object[] param = {id};

        return execute_Statement(sql,param);

    }

    public Boolean update(String student_id,String course_id,String teacher_id,Double grade){

        String sql = "UPDATE takes SET grade=? WHERE student_id=? AND course_id=? AND teacher_id=? ";

        Object[] param = {grade,student_id,course_id,teacher_id};

        return execute_Statement(sql,param);

    }

}
