package java_study.chapter6.ch10;

public class StudentTest {
    public static void main(String[] args) {
        MyLogger myLogger = MyLogger.getLogger();

        String name = null;
        try{
            Student student = new Student(name);

        }catch( StudentNameFormatException e ){
            myLogger.warning(e.getMessage());
        }

        try{
            Student student = new Student("이 규 빈");
        }catch ( StudentNameFormatException e){
            myLogger.warning(e.getMessage());
        }

        Student student = new Student("이규팔");

        System.out.println(student.getName());

    }
}
