package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String words = br.readLine();

        char[] targets = new char[] {'U','C', 'P', 'C'};

        int index = 0;

        boolean flag = false;
        for (int i =0; i < words.length(); i++){
            if (targets[index] == words.charAt(i)){
                index ++;
            }
            if (index == 4){
                flag = true;
                break;
            }
        }

        if (flag) System.out.println("I love UCPC");
        else System.out.println("I hate UCPC");
    }
}
