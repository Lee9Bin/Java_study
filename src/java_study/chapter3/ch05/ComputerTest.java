package java_study.chapter3.ch05;

public class ComputerTest {
    public static void main(String[] args){
        Computer desktop = new Desktop();
        Computer notebook = new MyNoteBook();
        desktop.typing();
        notebook.typing();
    }
}
