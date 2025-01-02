package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class P9872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> groups = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] group = br.readLine().split(" ");
            Arrays.sort(group);

            StringBuilder sb = new StringBuilder();
            for (String name : group) {
                sb.append(name).append(" ");
            }

            if (groups.containsKey(sb.toString())) {
                groups.put(sb.toString(), groups.get(sb.toString()) + 1);
            } else {
                groups.put(sb.toString(), 1);
            }
        }

        int maxCount = 0;
        for (String name : groups.keySet()) {
            maxCount = Math.max(maxCount, groups.get(name));
        }

        System.out.println(maxCount);
    }
}
