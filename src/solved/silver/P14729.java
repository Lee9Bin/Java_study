package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P14729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double[] score = new double[N];

        for (int i = 0 ; i < N; i++){
            score[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(score);

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < 7; i++){
            sb.append(String.format("%.3f",score[i])).append("\n");
        }
        System.out.println(sb);
    }
}
