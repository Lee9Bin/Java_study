package java_study.chapter3.ch11;
//추상클래스 abstract를 이용해 선언 각 레벨이 공통적으로 go메서드를 호출하면 동일한 루틴을
//가지지만 각 레벨의 능력이 다르므로 run(),jump()등 추상메서드로 선언해서 상속을 통해
//하위클래스들이 오버라이딩 할 수 있도록
//추상클래스는 new할 수 없다.
public abstract class PlayerLevel {
    public abstract void run();
    public abstract void jump();
    public abstract void turn();
    public abstract void showLevelMessage();

//  템플릿으로 구현 (why? 어떤 레벨이든 go메서드를 호출하면 이러한 시나리오대로 움직일수 있게하기 위해)
    final public void go (int count){
        run();
        for (int i = 0; i< count; i++){
            jump();
        }
        turn();
    }
}
