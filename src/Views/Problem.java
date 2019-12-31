package Views;

public class Problem {

    private String choose_1;
    private String choose_2;
    private String choose_3;
    private String choose_4;

    private String question;
    private Integer id; //primary
    private Integer answer_id;
    private String course_id;

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public Integer getAnswer_id() {
        return answer_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoose_1() {
        return choose_1;
    }

    public void setChoose_1(String choose_1) {
        this.choose_1 = choose_1;
    }

    public String getChoose_2() {
        return choose_2;
    }

    public void setChoose_2(String choose_2) {
        this.choose_2 = choose_2;
    }

    public String getChoose_3() {
        return choose_3;
    }

    public void setChoose_3(String choose_3) {
        this.choose_3 = choose_3;
    }

    public String getChoose_4() {
        return choose_4;
    }

    public void setChoose_4(String choose_4) {
        this.choose_4 = choose_4;
    }
}
