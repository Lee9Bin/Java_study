package java_study.chapter6.ch20;

public class Student extends Thread{
    public Student(String name){
        super(name);
    }
    public void run(){
        try {
        String title = LibraryMain.library.lendBook();
        if( title == null){
            System.out.println(getName() + " 빌리지 못했습니다.");
            return;
        }
        sleep(5000);
        LibraryMain.library.returnBook(title);

        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}
