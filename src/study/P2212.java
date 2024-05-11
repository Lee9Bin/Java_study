package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if (n <= k){
            System.out.println(0);
        }

        else{
            int[] sensor = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i =0; i < n; i++){
                sensor[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(sensor);

            int[] diff = new int[n-1];
            for (int i=0; i < n-1; i++){
                diff[i] = sensor[i+1] - sensor[i];
            }

            Arrays.sort(diff);

            int result = 0;
            for (int i = 0; i < n-k; i++) result += diff[i];
            System.out.println(result);
        }
    }
}
