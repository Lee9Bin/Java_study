package java_study.chapter2.ch09;

public class Employee {
//  static변수는 공통으로 사용하는 변수가 필요할때 사용 ex)사번, 학번 등
//  인스턴스가 생성될 때 만들어지는 변수가 아닌, 처음 프로그램이 메모리 로딩 될때 할당

    private static int serialNum = 100;
    private int employeeId;
    private String employeeName;
    private String deparment;

    public Employee(){
        employeeId = serialNum;
        serialNum ++;
    }

//  private로 선언 했으니 게터셋터 gogogog!
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDeparment() {
        return deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }

    public static int getSerialNum() {
        return serialNum;
    }
}
