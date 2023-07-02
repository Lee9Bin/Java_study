package java_study.chapter3.ch11;
//플레이거가 객체를 만들면 Player형의 한개의 level변수를 가질 수 있다.
//처음 만들어지는 플레이어는 초보자이고 레벨업을 할 수 있다.
public class Player {
    private PlayerLevel level;

    public Player(){
        level = new BeginnerLevel();
        level.showLevelMessage();
    }
    public void upgradeLevel(PlayerLevel level){
//      레벨을 업그레이드 해주면 사용되는 메서드를 바꿔줘야 하기 때문에(가상 메서드원리에 의해 재정의된 메서드가 사용이 돼)
//      매개변수 level의 인스턴스를 멤버변수의 적용
        this.level = level;
        level.showLevelMessage();
    }

    public PlayerLevel getLevel(){
        return level;
    }

    public void play(int count){
        level.go(count);
    }
}
