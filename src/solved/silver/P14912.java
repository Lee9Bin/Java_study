package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 1 ; i < n+1; i++){
            String chageStr = String.valueOf(i);
            for (int j = 0; j < chageStr.length(); j++){
                if (chageStr.charAt(j) -'0' == (char)target){
                    result ++;
                }
            }
        }
        System.out.println(result);
    }
}
