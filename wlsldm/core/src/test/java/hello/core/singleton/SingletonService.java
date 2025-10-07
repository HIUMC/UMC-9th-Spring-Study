package hello.core.singleton;

public class SingletonService {

    //처음 생성
    private static final SingletonService instance = new SingletonService();

    //꺼낼 수 있는 곳은 여기뿐이고 다른 곳에서는 생성이 안 돼
    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private로 만들어서 객체 생성을 막는 것임
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
