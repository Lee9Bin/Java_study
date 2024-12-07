package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class P18294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> names = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (names.containsKey(name)) names.put(name, names.get(name) + 1);
            else names.put(name, 1);
        }

        int maxCount = 0;
        for (String name : names.keySet()) {
            maxCount = Math.max(maxCount, names.get(name));
        }

        List<String> result = new ArrayList<>();
        for (String name : names.keySet()) {
            if (names.get(name) == maxCount) result.add(name);
        }

        Collections.sort(result);

        if (maxCount > n - maxCount) System.out.println(result.get(0));
        else System.out.println("NONE");
    }
}
