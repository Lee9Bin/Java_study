package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P9612 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> dic = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String target = br.readLine();

			if (dic.containsKey(target))
				dic.put(target, dic.get(target) + 1);
			else
				dic.put(target, 1);
		}

		int max = 0;
		for (String s : dic.keySet()) {
			max = Math.max(max, dic.get(s));
		}

		ArrayList<String> result = new ArrayList<>();
		for (String s : dic.keySet()) {
			if (dic.get(s) == max)
				result.add(s);
		}

		Collections.sort(result, Collections.reverseOrder());
		System.out.println(result.get(0) + " " + max);
	}
}
