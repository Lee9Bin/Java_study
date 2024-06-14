package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P16938 {

    static int N, L, R, X, result;
    static int[] problems;
    static ArrayList<Integer> selects = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        problems = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            problems[i] = Integer.parseInt(st.nextToken());
        }

        selects = new ArrayList<>();
        dfs(0, 0, 0);
        System.out.println(result);

    }

    public static void dfs(int total, int cnt, int start){
        if (cnt >= 2 && L <= total && total <= R){
            ArrayList<Integer> sub = new ArrayList<>(selects);
            Collections.sort(sub);
            if (sub.get(sub.size()-1) - sub.get(0) >= X) result++;
        }

        for (int i = start; i < N; i++){
            selects.add(problems[i]);
            dfs(total + problems[i], cnt + 1, i + 1);
            selects.remove(selects.size()-1);
        }
    }
}
