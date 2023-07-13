package java_study.chapter6.ch12;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
//      한바이트씩 쓰기
        try(FileOutputStream fos = new FileOutputStream("Output.txt")) {
            fos.write(65);
            fos.write(66);
            fos.write(67);
        } catch(IOException e) {
            System.out.println(e);
        }

//      배열에 담아서 한번에 쓰기                          (매개변수인자 두번째는 디폴트는 false true라 쓰면 누적된다라고 생각)
        FileOutputStream fos2 = new FileOutputStream("Output2.txt",true);
        try(fos2) {
            byte data = 65;
            byte[] bs = new byte[26];
            for(int i =0; i<bs.length; i++){
                bs[i] = data++;
            }
            fos2.write(bs);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
