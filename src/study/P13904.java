package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] works = new int[n][2];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            works[i][0] = Integer.parseInt(st.nextToken());
            works[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(works, (o1, o2) -> {
            return o2[0] - o1[0];
        });

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {return o2-o1;});

        int index = 0;
        int result = 0;

        for (int i = works[0][0] ; i>0; i--){
            while (true){
                if ( index == n || i > works[index][0]) break;
                heap.add(works[index][1]);
                index ++;
            }

            if (!heap.isEmpty()){
                result += heap.poll();
            }
        }

        System.out.println(result);
    }
}
