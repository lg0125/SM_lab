package Beans;

public class Teacher {
    private String id;
    private String password;

    private String rank_name;
    private String type = "teacher";
    private String name;
    private String introduction;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setRank_name(String rank_name) {
        this.rank_name = rank_name;
    }

    public String getRank_name() {
        return rank_name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
