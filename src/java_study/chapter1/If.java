package java_study.chapter1;

public class If {
    public static void main(String[] args){
        int age = 12;
        int charge;
//      if문과 else if문은 세트로 생각하고 그중 해당되는 것만 실행
        if(age < 8){
            charge = 1000;
            System.out.println("미 취학 아동입니다.");
        }
        else if(age < 14){
            charge = 2000;
            System.out.println("초등학생 입니다.");
        }
        else if(age < 20){
            charge = 2500;
            System.out.println("중, 고등학생 입니다.");
        }
        else{
            charge = 3000;
            System.out.println("일반인 입니다.");
        }

        System.out.println("입장료는 " + charge + "원입니다.");

//      이경우는 다른 if문들이 각각 해당되는지 체크를 해 각각의 if는 다른 세트라 생각하고 각 if 밑에 따라오는 else if, else가 한 세트
        if(age < 8){
            charge = 1000;
            System.out.println("미 취학 아동입니다.");
        }
        if(age < 14){
            charge = 2000;
            System.out.println("초등학생 입니다.");
        }
        if(age > 20){
            charge = 2500;
            System.out.println("중, 고등학생 입니다.");
        }
        else{
            charge = 3000;
            System.out.println("일반인 입니다.");
        }

        System.out.println("입장료는 " + charge + "원입니다.");
    }
}
