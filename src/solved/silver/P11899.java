package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P11899 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            char s = S.charAt(i);

            if (s == '('){
                stack.addLast(s);
            }
            else{
                if (stack.isEmpty()){
                    result ++;
                }
                else{
                    stack.pollLast();
                }
            }
        }
        result += stack.size();
        System.out.println(result);
    }
}
