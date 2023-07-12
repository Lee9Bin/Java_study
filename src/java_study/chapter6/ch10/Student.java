package java_study.chapter6.ch10;

public class Student {
    private String name;
    MyLogger logger = MyLogger.getLogger();

    public Student(String name){
        if(name == null){
            throw new StudentNameFormatException("이름은 null일 수 없습니다.");
        }
        if(name.split(" ").length>2) {
            throw new StudentNameFormatException("이름을 띄어 쓰지 마세요.");
        }
        this.name = name;
    }
    public String getName(){
        logger.fine("begin getStudentName()");
        return name;
    }
}
