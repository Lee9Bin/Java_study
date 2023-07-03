package java_study.chapter4.ch02;

public class Student {
    private int studentNum;
    private String studentName;

    public Student(int studentNum,String studentName){
        this.studentNum = studentNum;
        this.studentName = studentName;
    }
    public String toString(){
        return studentNum+','+studentName;
    }

    @Override
    public int hashCode() {
        return studentNum;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student){
            Student sdt = (Student) obj;
            if (this.studentNum == sdt.studentNum){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
