package java_study.chapter6.ch15;

import java.io.*;
//직렬화: 인스턴스의 상태를 그대로 파일 저장하거나 네트웍으로 전송하고 (serialization) 이를 다시 복원(deserializatio) 하는 방식
public class SerializationTest {
    public static void main(String[] args) {
        Person personLee = new Person("이규빈","사장");
        Person personKim = new Person("김삿갓","부사장");

        try(FileOutputStream fos  = new FileOutputStream("serial.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(personLee);
            oos.writeObject(personKim);
        }
        catch (IOException e){
            System.out.println(e);
        }

        try(FileInputStream fis  = new FileInputStream("serial.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            Person p1 = (Person)ois.readObject();
            Person p2 = (Person)ois.readObject();

            System.out.println(p1);
            System.out.println(p2);

        }
        catch (IOException e){
            System.out.println(e);
        }
        catch (ClassNotFoundException e){
            System.out.println(e);
        }
    }
}
