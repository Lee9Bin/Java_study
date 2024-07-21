package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P4659 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true){
            String str = br.readLine();
            if(str.equals("end")) break;

            boolean flag = true;
            int count = 0;
            int continuity = 0;
            char pre = ' ';
            for (int i = 0; i < str.length(); i++){
                char now = str.charAt(i);
                if (isVowels(now)) count++;
                if(isVowels(pre) == isVowels(now)) continuity++;
                else continuity = 1;

                if(continuity > 2 || (pre == now && (pre != 'e' && pre !='o'))){
                    flag = false;
                    break;
                }

                pre = now;
            }

            if (count == 0) flag = false;

            if (flag) sb.append('<').append(str).append("> is acceptable.\n");
            else sb.append('<').append(str).append("> is not acceptable.\n");


        }
        System.out.println(sb);
    }

    public static boolean isVowels(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
