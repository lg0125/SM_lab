package Beans;

import java.sql.Date;

public class Reply {

    private String content;
    private Date time;
    private String teacher_id;
    private String teacher_name;
    private String teacher_photo;

    private Integer message_id;

    private Integer id;

    public String getTeacher_photo() {
        return teacher_photo;
    }

    public void setTeacher_photo(String teacher_photo) {
        this.teacher_photo = teacher_photo;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public Integer getMessage_id() {
        return message_id;
    }

}
