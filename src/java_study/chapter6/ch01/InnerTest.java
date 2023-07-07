package java_study.chapter6.ch01;

class OutClass{
    private int num = 10;
    static int sNum = 20;
    private InClass inClass;

    public OutClass(){
        inClass = new InClass();
    }

     private class InClass{
        int inNum = 100;

        //이건 오류가 발생 why?
        //내부 클래스는 외부클래스가 생성이 되고 생성이 된다. -> static 변수는 외부 클래스 생성과 관계없이 사용이 가능한 변수니깐 안돼
        //static int sInNum = 500;

        void inTest(){
            System.out.println("OutClass num = " +num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수)");
        }
    }

    public void usingClass(){
        inClass.inTest();
    }

    static class InStaticClass{
        int iNum = 100;
        //  static 으로 클래스를 선언하면 가능하지
        static int isNum = 200;

        void inTest(){
//          num에서 오류가 생겨 그러면 왜겠어? static이라는건 생성전에 만들어져 있는 거잖아 그니깐 num은 외부클래스에서 인스턴스가 생성될때
//          만들어지는거잖아 그래서 만들어져 있을수도 있고 안만들어져 있을 수 있으니깐 오류 발생
//            System.out.println("OutClass num = " +num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass num = " +sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + iNum + "(내부 클래스의 인스턴스 변수)");
            System.out.println("InClass inNum = " + isNum + "(내부 클래스의 스태틱 변수)");
        }
    }
}
public class InnerTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.usingClass();

//      내부 클래스를 private 선언 하지 않으면 문법적으로는 아래와 같이 가능
//      단, 외부클래스를 통해 new해야해
//        OutClass.InClass inner = outClass.new InClass();
//      가능하지 static 클래스로 선언 돼있으니깐
        OutClass.InStaticClass inStaticClass = new OutClass.InStaticClass();
        inStaticClass.inTest();
    }
}
