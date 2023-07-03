package java_study.chapter4;

class Book{

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return title + "," + author;
    }

}

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("데미안", "헤르만 헤세");
//      toString()을 재정의 하기전에는 java_study.chapter4.Book@2d209079
        System.out.println(book);
//      어어? 얘는 왜 str을 출력하면 위에와 같이 안나와?
//      why? String 클래스에 toString이 재정의가 돼있어서 그래 그래서 Book클래서에서도 재정의 해주면 똑같이 해줄 수 있어
        String str = new String("test");
        System.out.println(str);
    }
}
