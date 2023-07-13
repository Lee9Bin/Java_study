package java_study.chapter6.ch13;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest {
    public static void main(String[] args) {
        try(FileReader fis = new FileReader("reader.txt")){
            int i;
            while ((i = fis.read()) != -1){
                System.out.println((char) i);
            }
        }catch (IOException e){
            System.out.println(e);
        }

        try(FileWriter fw = new FileWriter("writer.txt")){
            fw.write('A');    // 문자 하나 출력
            char buf[] = {'B','C','D','E','F','G'}; // 배열에 담아서
            fw.write(buf); //문자 배열 출력
            fw.write(buf, 1, 2); //문자 배열의 일부 출력

            fw.write("안녕하십니까. 인사 올리겠습니다!!!!"); //String 출력

            fw.write("65");  //숫자를 그대로 출력
        }catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("출력이 완료되었습니다.");

    }
}
