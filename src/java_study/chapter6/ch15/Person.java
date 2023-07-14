package java_study.chapter6.ch15;

import java.io.*;

//public class Person implements Serializable {
//    String name;
//    String job;
////  직렬화 할때 무시할거면 transient로
//    public Person(){}
//
//    public Person(String name, String job){
//        this.name = name;
//        this.job = job;
//    }
//
//    public String toString(){
//        return name + " " + job;
//    }
//}


//writerExternal()과 readExternal()메서드를 구현해야 한다.
//프로그래머가 직접 객체를 읽고 쓰는 코드를 구현 할 수 있다.
class Person implements Externalizable {

    String name;
    String job;

    public Person() {}

    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String toString()
    {
        return name + "," + job;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(job);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        job = in.readUTF();
    }

}

