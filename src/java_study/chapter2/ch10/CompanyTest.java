package java_study.chapter2.ch10;

public class CompanyTest {
    public static void main(String[] args) {
//      스태틱 메서드는 클래스이름.매서드이름으로 호출
        Company company1 = Company.getInstance();
        Company company2 = Company.getInstance();

        System.out.println(company1);
        System.out.println(company2);
    }
}
