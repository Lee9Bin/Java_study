package java_study.chapter6.ch20;

public class LibraryMain {
    static Library library = new Library();
    public static void main(String[] args) {

//      책이 학생수보다 적으면 오류가 나 (리소스가 부족한거지)
//      synchronized 처리해서 못빌리는 쓰레드는 포기하는 방법이 있어

        Student st1 = new Student("학생1");
        Student st2 = new Student("학생2");
        Student st3 = new Student("학생3");
        Student st4 = new Student("학생4");
        Student st5 = new Student("학생5");
        Student st6 = new Student("학생6");

        st1.start();
        st2.start();
        st3.start();
        st4.start();
        st5.start();
        st6.start();
    }
}
