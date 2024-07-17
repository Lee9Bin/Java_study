package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> heap = new PriorityQueue<>(((int[] o1, int[] o2) -> {
            return
                    o2[0] != o1[0] ? o2[0] - o1[0] : o1[1]-o2[1];
        }));

        if ( N > 0){
            st = new StringTokenizer(br.readLine());
        }

        for (int i = 0; i < N; i++){
            heap.add(new int[] {Integer.parseInt(st.nextToken()),i});
        }

        int[] teasu = new int[] {score, N};
        heap.add(teasu);

        int result = -1;
        ArrayList<int[]> ranker = new ArrayList<>();

        while (!heap.isEmpty()){

            int[] nowScore = heap.poll();

            if (ranker.isEmpty()){
                nowScore[1] = 1;
                ranker.add(nowScore);
            }

            else {
                int[] pre = ranker.get(ranker.size()-1);
                int preScore = pre[0];

                if (preScore == nowScore[0]){
                    nowScore[1] = pre[1];
                    ranker.add(nowScore);
                }
                else{
                    nowScore[1] = ranker.size()+1;
                    ranker.add(nowScore);
                }
            }

        }

        for (int i = 0; i < P; i++){
            if (ranker.get(i) == teasu){
                result = teasu[1];
                break;
            }
        }
        System.out.println(result);
    }
}