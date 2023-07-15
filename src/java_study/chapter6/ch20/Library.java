package java_study.chapter6.ch20;

import java.util.ArrayList;

public class Library {
    public ArrayList<String> bookList;

    public Library(){
        bookList = new ArrayList<>();
        bookList.add("해리포터1");
        bookList.add("해리포터2");
        bookList.add("해리포터3");
//        bookList.add("해리포터4");
//        bookList.add("해리포터5");
//        bookList.add("해리포터6");
    }

    public synchronized String lendBook() throws InterruptedException {
        Thread t = Thread.currentThread();

//      포기하지않고 기다리게 하는 방법
        while (bookList.size() == 0){

            System.out.println(t.getName() +" 기다리고 있습니다.");
            wait();
            System.out.println(t.getName() +" 빌릴 준비로 깨어났습니다.");
        }


//      synchronized 처리해서 못빌리는 쓰레드는 포기하는 방법이 있어
        if(bookList.size() > 0){
            String book = bookList.remove(0);
            System.out.println(t.getName() +": "+ book + " 빌렸습니다.");
            return book;
        }
        else {
            return null;
        }
    }
    public synchronized void returnBook(String book){
        Thread t = Thread.currentThread();
        bookList.add(book);
//        notify(); // wait상태에 빠진 하나씩 스레드를 깨워
        notifyAll(); // 모두를 깨우는 경우 이때 책이 없으면 못빌리는 경우도 생겨나 그렇다면 다시 wait처리를 해줘야해
        System.out.println(t.getName() +": "+ book + " 반납했습니다.");
    }
}
