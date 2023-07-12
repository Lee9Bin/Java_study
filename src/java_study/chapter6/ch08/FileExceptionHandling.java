package java_study.chapter6.ch08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileExceptionHandling {
    public static void main(String[] args) {
        FileInputStream fis = null;
//      이때 항상 수행돼야하는 코드들이 있어 그걸 finall을 사용하는거야
//        try {
////          파일은 프로젝트 하위에 만든것을 우선 찾아
//            fis = new FileInputStream("a.txt");
//            try {
//                fis.close();
//            }catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            try {
//                fis.close();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//            e.printStackTrace();
//        }
        try {
            fis = new FileInputStream("a.txt");
            System.out.println("read");
        } catch (FileNotFoundException e) {
            System.out.println("첫번째 캐치");;
//            return;  // finally는 실행이 된다.
        }finally {
            System.out.println("finally는 try가 실행이되면 항상 실행이 돼요.");

            try {
                fis.close();
            }
            catch (NullPointerException e){
                System.out.println("2-1 캐치");
                }
            catch (IOException e){
                System.out.println("2-2 캐치");
            }
        }

        System.out.println("비정상으로 멈추지 않았습니다.");
        try(FileInputStream fis2 = new FileInputStream("a.txt")){
            System.out.println("read");
        } catch (FileNotFoundException e) {
            System.out.println("파일이 존재 하지 않습니다.");
        } catch (IOException e) {
            System.out.println("close를 할 수 없습니다.");
        }
        System.out.println("비정상으로 멈추지 않았습니다.");
    }    
}
