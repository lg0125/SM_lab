package DAOs;

import Beans.Student;

import java.util.ArrayList;

public class StudentDAO extends BaseDAO {

    public ArrayList<Student> changeInfo_query(String id,String password){

        Class<Student> clazz = Student.class;

        String sql = "SELECT * FROM student WHERE id=? and password=? ";

        Object[] param = {id,password};

        return execute_Query(clazz,sql,2,param);

    }

    public ArrayList<Student> query(String id){
        Class<Student> clazz = Student.class;
        String sql = "SELECT * FROM student WHERE id=? ";
        Object[] param = {id};
        return execute_Query(clazz,sql,param.length,param);
    }

    public ArrayList<Student> query(String id,String name){
        Class<Student> clazz = Student.class;

        String sql = "SELECT * FROM student WHERE 1 ";
        String sql_id = " and 1 ";
        String sql_name = " and 1 ";

        int i = 0;
        Object[] param = new Object[2];
        if(!id.equals("")){
            sql_id = " and id=? ";
            param[i++] = id;
        }
        if(!name.equals("")){
            sql_name = " and name like ? ";
            param[i++] = "%"+name+"%";
        }
        sql += sql_id + sql_name;

        return execute_Query(clazz,sql,i,param);
    }

    public Boolean add(String id,String password,String name){
        String sql = "INSERT INTO student (id,password,name) "
                    +"VALUES (?,?,?) ";

        String sql_user = "INSERT INTO user(id,password,type) "
                         +"VALUES(?,?,'student') ";

        Object[] param_user = {id,password};

        Object[] param = {id,password,name};

        return execute_Statement(sql,param) && execute_Statement(sql_user,param_user);
    }

    public Boolean delete(String id){
        String sql = "DELETE FROM student WHERE id=? ";
        Object[] param = {id};
        return execute_Statement(sql,param);
    }

    public Boolean update_password(String id,String password){
        String sql = "UPDATE student SET password=? WHERE id=? ";
        Object[] param = {password,id};
        return execute_Statement(sql,param);
    }

    public Boolean update_name(String id,String name){
        String sql = "UPDATE student SET name=? WHERE id=? ";
        Object[] param = {name,id};
        return execute_Statement(sql,param);
    }

    public Boolean update_id(String old_id,String new_id){
        String sql = "UPDATE student SET id=? WHERE id=? ";
        Object[] param = {new_id,old_id};
        return execute_Statement(sql,param);
    }

    public Boolean changeInfo(String old_id,String new_id,String new_password){

        String sql = "UPDATE student SET id=?,password=? WHERE id=? ";

        Object[] param = {new_id,new_password,old_id};

        return execute_Statement(sql,param);

    }

    public Boolean updatePhoto(String id,String photo){

        String sql = "UPDATE student SET photo=? WHERE id=? ";

        Object[] param = {photo,id};

        return  execute_Statement(sql,param);

    }

}
