package java_study.chapter6.ch12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

    public static void main(String[] args) {
//      한바이트씩
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("Input.txt");
//          read()메서드가 더이상 읽을게 없으면 -1을 반환해
            System.out.println((char) fis.read());
            System.out.println((char) fis.read());
            System.out.println((char) fis.read());
        } catch (IOException e) {
            e.printStackTrace();
            try {
                fis.close();
            } catch (NullPointerException e1) {
                System.out.println(e1);
            } catch (IOException e2) {
                System.out.println(e2);
                ;
            }
        } finally {
            try {
                fis.close();
            } catch (IOException e1) {
                System.out.println(e1);
                ;
            } catch (NullPointerException e2) {
                System.out.println(e2);
            }
        }
//      파일의 끝까지 한 바이트씩
        int i;
        try(FileInputStream fis2 = new FileInputStream("Input.txt")){
            while ((i = fis2.read()) != -1){
                System.out.println((char) i);
            }
        }catch(Exception e){
            System.out.println(e);
        }
//      바이트 배열로 자료 읽기
        try(FileInputStream fis3 = new FileInputStream("Input.txt")){
            byte[] bs = new byte[10];
            while ((i = fis3.read(bs)) != -1){
//                for (int ch : bs){
//                    System.out.print((char)ch);
//                }
//                System.out.println(" : " + i + "바이트 읽음");
//            }
//            ABCDEFGHIJ : 10바이트 읽음
//            KLMNOPQRST : 10바이트 읽음
//            UVWXYZQRST : 6바이트 읽음 (why? 위에서 위에 읽은 자료가 남아있으니깐)
//            그래서 반목문을 아래와 같이 바꿔주면 되지만 여전히 읽은 자료는 남아있어
                for (int j = 0; j<i; j++){
                    System.out.print((char)bs[j]);
                }
                System.out.println(" : " + i + "바이트 읽음");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
