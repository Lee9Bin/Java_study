package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class P9414 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tests; t++){
			int result = 0;
			ArrayList<Integer> grounds = new ArrayList<>();
			int start = 1;
			while (true){
				int num = Integer.parseInt(br.readLine());
				if (num == 0) break;
				grounds.add(num);
			}
			Collections.sort(grounds);

			for (int i = grounds.size()-1; i >= 0; i--){
				result += 2 * Math.pow(grounds.get(i), start);
				start++;
			}

			if (result > 5000000) sb.append("Too expensive").append("\n");
			else sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
