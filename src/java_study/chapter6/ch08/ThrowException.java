package java_study.chapter6.ch08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowException {
//    예외처리를 미룬다. 이 메서드를 사용하는 쪽에서 예외를 처리
    public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Class c = Class.forName(className);
        return c;
    }
    public static void main(String[] args) {
        ThrowException test = new ThrowException();

        try {
            test.loadClass("a.txt","abc");
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
//      하나의 블럭에서 처리
//        catch (FileNotFoundException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//      어떤 예외든 처리해준다.(단, 명시적으로 위에서 처리한 부분이 있다면 맨마지막에 위치해야한다.)
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
