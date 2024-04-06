package solved.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int[] gates = new int[G+1];

        for (int i = 1; i < G+1; i++){
            gates[i] = i;
        }

        int result = 0;
        for (int i = 1; i < P+1; i++){
            int plane = Integer.parseInt(br.readLine());
            int next = plane;
            while (next >= 1 && gates[next] != next){
                next = gates[next];
            }

            if (next == 0){
                break;
            }
            else{
                result ++;
            }

            gates[next] = gates[next-1];
            gates[plane] = gates[next];

        }
        System.out.println(result);
    }
}
