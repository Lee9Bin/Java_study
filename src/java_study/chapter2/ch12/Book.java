package java_study.chapter2.ch12;

public class Book {
    private String title;
    private String author;

    public Book(){
//        default 생성자
    }
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void showInfo(){
        System.out.println(title+author);
    }
}
