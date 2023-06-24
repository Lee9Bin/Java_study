package java_study.chapter2.ch09;

public class EmployeeTest {
    public static void main(String[] args){
//      홍길동에 serialnum을 empliyeeId에 넣고 serialnum은 1증가
        Employee employeeLee = new Employee();
        employeeLee.setEmployeeName("홍길동");
//      그러고 나서 serialnum을 출력하고 나면 101
        System.out.println(employeeLee.getSerialNum());

//      김흥부에 serialnum을 empliyeeId에 넣고 serialnum은 1증가
        Employee employeeKim = new Employee();
        employeeKim.setEmployeeName("김흥부");
//      그러고 나서 serialnum은 102
//      이와 같이 두개의 인스턴스가 하나의 메모리를 공유
//      데이터 영역      스택 메모리     힙 메모리(동적메모리)
//      static변수(serialNum) <-- employeeLee --> employeeLee인스턴스
//          ^------------------ employeeKim --> employeeKim인스턴스
        System.out.println(employeeLee.getSerialNum());//      102
        System.out.println(employeeKim.getSerialNum());//      102
//      생성자를 통해 static 변수를 증가시켜 사번을 부여
        System.out.println(employeeLee.getEmployeeId());//   100
        System.out.println(employeeKim.getEmployeeId());//   101

    }
}
