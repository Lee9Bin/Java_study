package java_study.chapter2.ch03;

import java.security.PublicKey;

public class Myname {
    int age;
    String name;
    String home;
    String phone;

    public void Info(){
        System.out.println("이름: " + name+ "나이는: "+age+"사는 곳:" + home + "핸드폰 번호:" + phone);
    }
    public void setName(String name1){
        name = name1;
    }
}
