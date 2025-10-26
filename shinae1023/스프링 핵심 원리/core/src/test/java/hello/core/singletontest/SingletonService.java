package hello.core.singletontest;

public class SingletonService {
    /*
    싱글톤 패텅 : 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴이다.
                객체 인스턴스를 2개 이상 생성하지 못하도록 막아야한다
                -> private 생성자를 사용해서 외부에서 임의로 new 키워드를 사용하지 못하도록 막아야 함
     */

    //1. static 영역에 객체를 딱 1개만 생성 따라서 private로 막음
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){ //객체 조회
        return instance;
    } // 항상 같은 인스턴스를 반환

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
