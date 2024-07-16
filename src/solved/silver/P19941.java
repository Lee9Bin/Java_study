package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] chars = br.readLine().toCharArray();


        int result = 0;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N;i++){
            if (chars[i] == 'P'){
                int start = Math.max(0, i - K);
                int end = Math.min(N, i+K);

                for (int j = start; j < end; j++){
                    if (chars[j] == 'H' && !visited[j]){
                        result++;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }
        System.out.println(result);

    }
}
