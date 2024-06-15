package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        str = str.replace("pi", "*");
        str = str.replace("ka", "*");
        str = str.replace("chu", "*");

        boolean flag = true;
        for (int i = 0 ; i < str.length(); i++){
            if (str.charAt(i) != '*') flag = false;
        }
        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
