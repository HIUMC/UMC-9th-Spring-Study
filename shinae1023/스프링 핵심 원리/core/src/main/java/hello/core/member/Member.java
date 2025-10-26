package hello.core.member;

public class Member { //회원 정보 아이디 이름 등급

    public Member(Long id, String name, Grade grade) {
        this.Id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    private Long Id;
    private String name;
    private Grade grade;
}
