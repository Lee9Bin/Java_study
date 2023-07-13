package java_study.chapter6.ch14;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    public static void main(String[] args) {
//      FileInputStream으로 읽은 자료를 문자로 변환해준다. 보조스트림으로 (기반 스트림을 감싸준다)
        try (InputStreamReader fis = new InputStreamReader(new FileInputStream("reader.txt"))) {
            int i ;
            while ((i = fis.read()) != -1){
                System.out.println((char)i);
            }
        } catch (IOException e) {

        }
    }
}
