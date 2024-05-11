package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        String boom = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<str.length; i++){
            stack.add(str[i]);
            if (stack.peek() == boom.charAt(boom.length()-1) && stack.size() >= boom.length()){
                boolean flag = true;
                for(int j = 0; j < boom.length(); j++){
                        if (stack.get(stack.size()-1-j) != boom.charAt(boom.length()-1-j)){
                            flag = false;
                            break;
                        }
                }

                if (flag){
                    for(int j = 0; j < boom.length(); j++){
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) System.out.println("FRULA");
        else{
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stack.size(); i++){
                sb.append(stack.get(i));
            }
            System.out.println(sb);

        }
    }
}
