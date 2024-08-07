package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P12760 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] people = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                people[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] person : people) {
            Arrays.sort(person);
        }

        int[] score = new int[N];

        for (int i = M - 1; i >= 0; i--) {
            int max = 0;
            for (int j = 0; j < N; j++) {
                max = Math.max(max, people[j][i]);
            }

            for (int j = 0; j < N; j++) {
                if (people[j][i] == max) score[j]++;
            }

        }

        int max = 0;
        for (int i : score) {
            max = Math.max(max, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (max == score[i]) sb.append(i + 1).append(" ");
        }
        System.out.println(sb);
    }
}
