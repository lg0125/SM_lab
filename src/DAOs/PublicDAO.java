package DAOs;

import Views.*;

import java.util.ArrayList;

public class PublicDAO extends BaseDAO {

    public Boolean add_User(String id,String password,String type){
        String sql = "INSERT INTO user (id,password,type) "
                    +"VALUES (?,?,?) ";
        Object[] param = {id,password,type};
        return execute_Statement(sql,param);
    }

    public ArrayList<Problem> query_Problem(String course_id){
        Class<Problem> clazz = Problem.class;
        String sql = "SELECT * FROM problem WHERE course_id=? ";
        int i = 1;
        Object[] param = {course_id};
        return execute_Query(clazz,sql,i,param);
    }

    public Boolean is_answer(Integer id,Integer submit_id){
        String sql = "SELECT * FROM problem WHERE id=? ";
        Class<Problem> clazz = Problem.class;
        int i = 1;
        Object[] param = {id};
        ArrayList<Problem> result = execute_Query(clazz,sql,param.length,param);
        Integer answer_id = result.get(0).getAnswer_id();
        return submit_id.equals(answer_id);
    }

    public ArrayList<User> signIn_query(String id,String password){

        Class<User> clazz = User.class;

        String sql = "SELECT * FROM user where id=? and password=? ";

        Object[] param = {id,password};

        return execute_Query(clazz,sql,2,param);

    }

    public Boolean changeInfo(String old_id,String new_id,String new_password){

        String sql = "UPDATE user SET id=?,password=? WHERE id=? ";

        Object[] param = {new_id,new_password,old_id};

        return execute_Statement(sql,param);

    }

    public Boolean delete_takes(String course_id){

        String sql = "DELETE FROM takes WHERE course_id=? ";

        Object[] param = {course_id};

        return execute_Statement(sql,param);

    }

    public Boolean delete_teaches(String course_id){

        String sql = "DELETE FROM teaches WHERE course_id=? ";

        Object[] param = {course_id};

        return execute_Statement(sql,param);

    }

    public Boolean update_teaches(String oldTeacherId,String newTeacherId){

        String sql = "UPDATE teaches SET teacher_id=? WHERE teacher_id=? ";

        Object[] param = {newTeacherId,oldTeacherId};

        return execute_Statement(sql,param);

    }

    public Boolean update_takes(String oldTeacherId,String newTeacherId){

        String sql = "UPDATE takes SET teacher_id = ? WHERE teacher_id = ? ";

        Object[] param = {newTeacherId,oldTeacherId};

        return execute_Statement(sql,param);

    }

    public ArrayList<TeacherCourse> query_TeacherCourseDept(){

        Class<TeacherCourse> clazz = TeacherCourse.class;

        String sql = "SELECT * FROM teacherCourse ORDER BY course_id ";

        Object[] param = {};

        return execute_Query(clazz,sql,param.length,param);

    }

    public ArrayList<TeacherCourse> query_TeacherCourseTeach(){

        Class<TeacherCourse> clazz = TeacherCourse.class;

        String sql = "SELECT * FROM teacherCourse ORDER BY teacher_id ";

        Object[] param = {};

        return execute_Query(clazz,sql,param.length,param);

    }

    public ArrayList<TeacherCourse> query_TeacherCourse(){

        Class<TeacherCourse> clazz = TeacherCourse.class;

       String sql = "SELECT * FROM teacherCourse ";

        Object[] param = {};

        return execute_Query(clazz,sql,param.length,param);
    }

    public ArrayList<TeacherCourse> query_TeacherCourse(String teacher_id){

        Class<TeacherCourse> clazz = TeacherCourse.class;

        String sql = "SELECT * FROM teacherCourse WHERE teacher_id=? ";

        Object[] param = {teacher_id};

        return  execute_Query(clazz,sql,param.length,param);
    }

    public Boolean add_TeacherCourse(String course_id,String teacher_id){

        String sql = "INSERT INTO teaches (course_id,teacher_id) "
                    +"VALUES (?,?) ";

        Object[] param = {course_id,teacher_id};

        return execute_Statement(sql,param);

    }

    public ArrayList<StudentGradeList> query_studentGrade(){

        Class<StudentGradeList> clazz = StudentGradeList.class;

        String sql = "SELECT * FROM studentGrade ";

        Object[] param = {};

        return execute_Query(clazz,sql,param.length,param);

    }

    public ArrayList<StudentGradeList> query_studentGrade(String student_id){

        Class<StudentGradeList> clazz = StudentGradeList.class;

        String sql = "SELECT * FROM studentGrade WHERE student_id=? ";

        Object[] param = {student_id};

        return execute_Query(clazz,sql,param.length,param);

    }

    public ArrayList<StudentGradeList> query_StudentGradeWarning(String teacher_id){

        Class<StudentGradeList> clazz = StudentGradeList.class;

        String sql = "SELECT * FROM studentGrade WHERE teacher_id=? AND grade<80 ";

        Object[] param = {teacher_id};

        return execute_Query(clazz,sql,param.length,param);

    }

    public ArrayList<StudentCourseList> query_studentCourse(String student_id){

        Class<StudentCourseList> clazz = StudentCourseList.class;


        String sql = "SELECT * FROM studentCourse WHERE student_id=? ";

        Object[] param = {student_id};

        return execute_Query(clazz,sql,param.length,param);

    }

   /* public ArrayList<SelectCourseList> query_SelectCourse(){

        Class<SelectCourseList> clazz = SelectCourseList.class;

        String sql = "SELECT * FROM selectCourse ";

        Object[] param = {};

        return execute_Query(clazz,sql,param.length,param);

    }*/

    public ArrayList<SelectCourseList> query_SelectCourse(String student_id){

        Class<SelectCourseList> clazz = SelectCourseList.class;

        String sql = "SELECT * FROM SelectCourse1 AS t1 WHERE t1.student_id=? "
                    +"AND (t1.course_id,t1.teacher_id) NOT IN "
                    +"(SELECT t2.course_id,t2.teacher_id FROM takes AS t2 WHERE t1.student_id=t2.student_id)";

        Object[] param = {student_id};

        return execute_Query(clazz,sql,param.length,param);

    }

    public Boolean add_SelectCourse(String student_id,String course_id,String teacher_id){

        String sql = "INSERT INTO takes (student_id,course_id,teacher_id) "
                    +"VALUES (?,?,?) ";

        Object[] param = {student_id,course_id,teacher_id};

        return execute_Statement(sql,param);

    }

    public Boolean delete_SelectCourse(String student_id,String course_id,String teacher_id){

        String sql = "DELETE FROM takes WHERE student_id=? AND course_id=? AND teacher_id=? ";

        String sql_warning = "DELETE FROM takes WHERE course_id=? AND teacher_id=? ";

        Object[] param = {student_id,course_id,teacher_id};

        Object[] param_warning = {course_id,teacher_id};

        return execute_Statement(sql_warning,param_warning) && execute_Statement(sql,param);

    }

    public ArrayList<CourseGradeList> query_courseGrade(String course_id,String teacher_id){

        Class<CourseGradeList> clazz = CourseGradeList.class;

        String sql = "SELECT * FROM courseGrade WHERE course_id=? AND teacher_id=? ";

        Object[] param = {course_id,teacher_id};

        return execute_Query(clazz,sql,param.length,param);

    }


}
