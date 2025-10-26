package hello.core.singletontest;

public class StatefulService {
    /* 싱글톤 방식 주의점 (중요)
        객체 인스턴스를 하나만 생성해서 공유하는 싱글톤 방식은 여러 클라이언트가
        하나의 같은 객체 인스턴스를 공유하므로 싱글톤 객체는 상태를 유지하게 설계하면 안됨
        무상태로 설계해야함
            - 특정 클라이언트에 의존 x
            - 특정 클라이언트가 값 변경 x
            - 가급적 읽기만 가능
            - 필드 대신에 자바에서 공유되지 않는 지역변수, 파라미터 등을 사용해야함
       공유 값 설정 xxxxx
     */

    private int price;//상태를 유지하는 필드

    public int order(String name, int price){
        System.out.println("name = "+name+" price = "+price);
 //       this.price = price; //여기가 문제
        return price; //지역 변수 값을 아예 넘겨서 리셋
    }

  //  public int getPrice(){
  //      return price;
   // }
}
