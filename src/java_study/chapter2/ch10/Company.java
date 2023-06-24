package java_study.chapter2.ch10;
// 싱글톤패턴
public class Company {

//  외부에서 생성자를 접근할수 없도록 private로 생성자 선언
    private static Company instance = new Company();

    private Company() {

    }
//  외부에서 유일한 인스턴스를 참조할수 있는 메서드 제공
    public static Company getInstance(){
        if (instance == null){
            instance = new Company();
        }

        return instance;
    }
}
