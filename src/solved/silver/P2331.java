package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        ArrayList<Integer> D = new ArrayList<>();

        boolean[] visited = new boolean[300000];
        visited[A] = true;
        D.add(A);


        int target = 0;
        while (true) {
            String now = String.valueOf(D.get(D.size() - 1));
            int newNum = 0;


            for (int i = 0; i < now.length(); i++) {
                newNum += Math.pow(now.charAt(i) - '0', P);
            }

            if (visited[newNum]) {
                target = newNum;
                break;
            }
            D.add(newNum);
            visited[newNum] = true;
        }
        int result = 0;
        for (Integer integer : D) {
            if (integer.equals(target)) break;
            result++;
        }
        System.out.println(result);
    }
}
