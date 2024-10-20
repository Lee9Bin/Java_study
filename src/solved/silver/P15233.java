package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P15233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        HashMap<String, String> teams = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            teams.put(st.nextToken(), "A");
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            teams.put(st.nextToken(), "B");
        }


        int AScore = 0;
        int BScore = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < G; i++) {
            String name = st.nextToken();
            if (teams.get(name).equals("A")) AScore++;
            else BScore++;
        }

        if (AScore > BScore) System.out.println("A");
        if (AScore < BScore) System.out.println("B");
        if (AScore == BScore) System.out.println("TIE");
    }
}
