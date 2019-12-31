package DAOs;

import Beans.Teacher;

import java.util.ArrayList;

public class TeacherDAO extends BaseDAO {

    public ArrayList<Teacher> changeInfo_query(String id,String password){

        Class<Teacher> clazz = Teacher.class;

        String sql = "SELECT * FROM teacher WHERE id=? and password=? ";

        Object[] param = {id,password};

        return execute_Query(clazz,sql,param.length,param);

    }

    public  ArrayList<Teacher> query(){
        Class<Teacher> clazz = Teacher.class;

        String sql = "SELECT * FROM teacher";

        Object[] param = {};

        return execute_Query(clazz,sql,param.length,param);
    }

    public  ArrayList<Teacher> query(String id){
        Class<Teacher> clazz = Teacher.class;

        String sql = "SELECT * FROM teacher WHERE id=? ";

        Object[] param = {id};

        return execute_Query(clazz,sql,param.length,param);
    }

    public ArrayList<Teacher> query(String id,String name,String rank_name){
        Class<Teacher> clazz = Teacher.class;

        String sql = "SELECT * FROM teacher WHERE 1 ";
        String sql_id = " and 1 ";
        String sql_name = " and 1 ";
        String sql_rank = " and 1 ";

        int i = 0;
        Object[] param = new Object[3];
        if(!id.equals("")){
            sql_id = " amd id=? ";
            param[i++] = id;
        }else{
            if(!name.equals("")){
                sql_name = " and name like ? ";
                param[i++] = "%"+name+"%";
            }
            if(!rank_name.equals("")){
                sql_rank = " and rank_name like ? ";
                param[i++] = "%"+rank_name+"%";
            }
        }
        return execute_Query(clazz,sql,i,param);
    }

    public Boolean add(String id,String password,String name,String rank_name,String introduction){
        String sql = "INSERT INTO teacher (id,password,name,rank_name,introduction) "
                    +"VALUES(?,?,?,?,?)";

        String sql_user = "INSERT INTO user (id,password,type) "
                         +"VALUES(?,?,'teacher') ";

        Object[] param = {id,password,name,rank_name,introduction};

        Object[] param_user = {id,password};

        return execute_Statement(sql,param) && execute_Statement(sql_user,param_user);
    }

    public Boolean delete_id(String id){
        String sql = "DELETE FROM teacher WHERE id=? ";
        Object[] param = {id};
        return execute_Statement(sql,param);
    }

    public Boolean update_password(String id,String password){
        String sql = "UPDATE teacher SET password=? WHERE id=? ";
        Object[] param = {password,id};
        return execute_Statement(sql,param);
    }

    public Boolean update_name(String id,String name){
        String sql = "UPDATE teacher SET name=? WHERE id=? ";
        Object[] param = {name,id};
        return execute_Statement(sql,param);
    }

    public Boolean update_rank(String id,String rank_name){
        String sql = "UPDATE teacher SET rank_name=? WHERE id=? ";
        Object[] param = {rank_name,id};
        return execute_Statement(sql,param);
    }

    public Boolean introduction(String id,String introduction){
        String sql = "UPDATE teacher SET introduction=? WHERE id=? ";
        Object[] param = {introduction,id};
        return execute_Statement(sql,param);
    }

    public Boolean changeInfo(String old_id,String new_id,String new_password){
        String sql = "UPDATE teacher SET id=?,password=? WHERE id=? ";
        Object[] param = {new_id,new_password,old_id};
        return execute_Statement(sql,param);
    }

    public Boolean updatePhoto(String id,String photo){

        String sql = "UPDATE teacher SET photo=? WHERE id=? ";

        Object[] param = {photo,id};

        return execute_Statement(sql,param);

    }

}
