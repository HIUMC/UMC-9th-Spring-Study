public class UMC9thMember{
    private int age;
    private String nickname;
    private String school;
    public String studyPart;

    public UMC9thMember() {}

    public UMC9thMember(int age, String nickname, String school, String studyPart) {
        this.age = age;
        this.nickname = nickname;
        this.school = school;
        this.studyPart = studyPart;
    }
}

public static void main(String[] args) {
    UMC9thMember umc9thMember =
            new UMC9thMember(27, "비니", "홍익대", "스프링");
    //new 키워드를 이용한 객체 관리
}