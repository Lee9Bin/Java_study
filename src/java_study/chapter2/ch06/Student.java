package java_study.chapter2.ch06;

public class Student {
//  private 같은 클래스 내부에서만 접근이 가능(외부 클래스, 상속 관계의 클래스에서도 접근이 불가능하다)
    private String priname;
//  아무것도 없는경우 default 같은 패키지 내부에서만 접근가능(상속관계라도 패키지가 다르면 안됨)
    String dename;
//  protected 같은 패키지나 상속관계의 클래스에서 접근가능하고 그 외 외부에서는 접근 불가
    protected String proname;
//  public 클래스의 외부 어디서나 접근 가능
    public String puname;
    public void printStudent(){
        System.out.println(priname);
        System.out.println(dename);
        System.out.println(proname);
        System.out.println(puname);
    }
//    public static void main(String[] args){
//        Student Lee = new Student();
//        System.out.println(Lee.priname);
//        System.out.println(Lee.dename);
//        System.out.println(Lee.proname);
//        System.out.println(Lee.puname);
//    }

    public String getPriname() {
        return priname;
    }

    public void setPriname(String priname) {
        this.priname = priname;
    }
}
