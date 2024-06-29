package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P15702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] score = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < M; i++){
            st =new StringTokenizer(br.readLine());
            int[] student = new int[2];
            student[0] = Integer.parseInt(st.nextToken());
            int total = 0;
            for (int j = 0; j < N; j++){
                String status = st.nextToken();
                if (status.equals("O")) total += score[j];
            }
            student[1] = total;
            result.add(student);
        }

        result.sort((int[] o1, int[] o2) -> {
            return o2[1] != o1[1] ? o2[1] - o1[1] : o1[0] - o2[0] ;
        });

        System.out.println(result.get(0)[0] + " " + result.get(0)[1]);
    }
}
