package java_study.chapter1;
//switch case문
public class SwitchCase {
    public static void main(String[] args){
//  if, else if, else문을 좀더 가독성있게 switch로 구현가능
        int month = 10;
        int day;

        switch(month){
//          case가 맞아도 모든 케이스를 돌아버리기 때문에 break를 걸어야해
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                day = 31;
                break;
            case 4: case 6: case 9: case 11:
                day = 30;
                break;
            case 2:
                day = 28;
                break;
            default:
                day = 0;
                System.out.println("존재하지 않는 달 입니다.");

        }
        System.out.println(month + "월은 " + day + "일입니다.");

    }
}
