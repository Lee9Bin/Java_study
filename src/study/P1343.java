package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < st.length()+1; i++){
            if (i == st.length()|| st.charAt(i) == '.'){
                int AAAA = count / 4;
                for (int k = 0; k <AAAA; k++){
                    sb.append("AAAA");
                }
                count %= 4;
                int BB = count / 2;
                for (int k = 0; k <BB; k++){
                    sb.append("BB");
                }
                count %= 2;
                if (count > 0){
                    System.out.println(-1);
                    System.exit(0);
                }
                if (i != st.length()) sb.append(".");
            }
            else if (st.charAt(i) != '.'){
                count ++;
            }
        }
        System.out.println(sb);
    }
}
