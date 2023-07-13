package java_study.chapter6.ch11;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInTest {
    public static void main(String[] args) {
        System.out.println("알파벳 하나를 쓰고 [Enter]를 누르세요");
        int i;

        try {
//          이상태에서는 1바이트를 읽오 있기 때문에 한글을 입력하면 깨진다. 그래서 주석과 같이 바꾸면 가능
//            InputStreamReader irs = new InputStreamReader(System.in);
//            while ((i = irs.read()) != '\n')
            while ((i = System.in.read()) != '\n'){
                System.out.println(i);
                System.out.println((char)i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
