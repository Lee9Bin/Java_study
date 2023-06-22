package java_study.chapter2.ch06;

public class StudentTest {
    public static void main(String[] args){
        Student Lee = new Student();

//      System.out.println(Lee.priname); 오류발생 클래스 외부에서 접근
//      Lee.priname = "Lee";
//      그래서 접근하기위해서는 get set 메서드를 사용해야해
        Lee.setPriname("Lee");

        System.out.println(Lee.getPriname());
        System.out.println(Lee.dename); //같은 패키지
        System.out.println(Lee.proname); // 같은 패키지
        System.out.println(Lee.puname); // 클래스외부 어디서나 가ㅣ

    }

}
