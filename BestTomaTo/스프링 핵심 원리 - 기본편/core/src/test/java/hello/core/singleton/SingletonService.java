package hello.core.singleton;

public class SingletonService {

    private static SingletonService instance = new SingletonService();

    // 싱글톤 객체를 조회하기 위해선 오직 getInstance getter로만 조회 가능
    // 메소드가 조회되면 매번 똑같은 instance 객체를 반환한다.
    public static SingletonService getInstance(){
        return instance;
    }

    // 생성자를 private로 두어 오직 한 개의 객체 인스터만 허용
    // SingletonService 객체를 생성하기 위해선 반드시 getInstance 메소드를 호출해야 한다.
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 생성 완료");
    }
}
