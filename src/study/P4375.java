package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P4375 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            int now = 0;
            int cnt = 0;
            try {
                int n = Integer.parseInt(br.readLine());
                while (true){
                    now = (int) ((now * 10 + 1) % n);
                    cnt += 1;
                    if (now % n == 0){
                        System.out.println(cnt);
                        break;
                    }
                }
            }
            catch (Exception e){
                break;
            }

        }
    }
}
