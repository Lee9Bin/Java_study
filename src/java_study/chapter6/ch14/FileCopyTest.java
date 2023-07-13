package java_study.chapter6.ch14;

import java.io.*;
import java.net.Socket;

public class FileCopyTest {
    public static void main(String[] args) {
        long milli = 0;
        try(FileInputStream fis = new FileInputStream("a.zip");
            FileOutputStream fos = new FileOutputStream("copy.zip");
//          속도차이가 엄청나다.
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos)){
                milli = System.currentTimeMillis();

                int i;
                while ((i = bis.read()) != -1 ){
                    bos.write(i);
                }
                milli = System.currentTimeMillis()-milli;
            }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(milli + "소요 됐습니다.");

        Socket socket= new Socket();
//      socket.getInputStream(); 한글이 안돼
//      new InputStreamReader(socket.getInputStream()); 한글 가능!
//      new BufferdReader(new InputStreamReader(socket.getInputStream())); 속도가 빨라진다.
        }
    }
