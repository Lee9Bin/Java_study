package java_study.chapter3.ch11;

public class MainBoardPlay {
    public static void main(String[] args) {
//      플레이어 객체가 만들어지면 처음에는 초보자 이므로
//      플레이어 생성자를 통해 level이 beginnerLevel인스턴스를 가르킨다.
        Player player = new Player();
        player.play(1);



//      (이때 PlayerLevel로 new 해도 되는거 아니야 ? 삐이이이이이 추상클래스는 인스턴스화 할 수 없어)
//      재정의된 메서드를 사용하기위해 해당레벨의 클래스로 인스턴스화
        AdvancedLevel aLevel = new AdvancedLevel();
//        ^---이부분을 PlayerLevel이나 하위클래스로 타입을 선언해도 된다. 단, 각레벨에 따라서 능력이 추가 됐을 경우 해당 타입의 메서드만 호출할 수 있기때문에
//        경우에 따라 잘 선택하기
        player.upgradeLevel(aLevel);
        player.play(2);

        SuperLevel sLevel = new SuperLevel();
        player.upgradeLevel(sLevel);
        player.play(3);
    }
}
