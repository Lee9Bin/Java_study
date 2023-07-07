package java_study.chapter6.ch03;
//람다식 테스트를 위해서는 함수적 인터페이스가 필요하다.
//익명 함수와 매개 변수만으로 구현되므로 인터페이스는 단 하나의 메서드만을 선언해야한다.
//그래서 함수형 인터페이스라는 의미로 @FunctionalInterface 사용(메시드를 2개이상 선언시 쓰지 않으면 AddTest에서 오류가 나고 써주면 인터페이스에서 오류가 난다.)
@FunctionalInterface
public interface Add {
    public int add(int x, int y);
//    public int sub();
}

