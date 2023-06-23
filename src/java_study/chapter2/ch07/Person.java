package java_study.chapter2.ch07;

public class Person {
    String name;
    int age;

    public Person(){
//     디폴트 생성자
//     아무 값이 들어 오지 않을때 초기화를 하고 싶을때
//     this = 클래스에 생성자가 여러 개 인경우, this를 이용하여 생성자에서 다른 생성자를 호출할 수 있음
//     밑에와 같이 다른 생성자를 불러 와서 초기화 가능
        this("이름없음",1);
    }
    public Person(String name, int age){
//      this = 클래스 내에서 참조변수가 가지는 주소 값과 동일 한 주소 값을 가지는 키워드
        this.name = name;
        this.age = age;
    }
    public void showPerson(){
        System.out.println(name+','+age);
    }

    public Person getPerson() {
        return this;
    }

    public static void main(String[] args){
        Person person1 = new Person();
        person1.showPerson();

        Person person2 = new Person("LEe",19);
        person2.showPerson();


//      this가 가르키는 주소와 참조변수가 가르키는 주소는 같다.
        Person p = new Person();
        p.name = "James";
        p.age = 37;

        Person p2 = p.getPerson();
        System.out.println(p);
        System.out.println(p2);


    }
}
