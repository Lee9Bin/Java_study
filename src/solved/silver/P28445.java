package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P28445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> colors = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            colors.add(st.nextToken());
            colors.add(st.nextToken());
        }

        Collections.sort(colors);

        TreeSet<String> result = new TreeSet<>();

        for (int i = 0; i < colors.size(); i ++){
            for (int j = 0; j < colors.size(); j++){
                StringBuilder sb = new StringBuilder();
                sb.append(colors.get(i)).append(" ").append(colors.get(j));
                result.add(sb.toString());
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}
