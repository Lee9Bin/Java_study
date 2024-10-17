package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P16499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Set<String> words = new HashSet<>();

		for (int i = 0; i < N; i++){
			char[] word = br.readLine().toCharArray();
			Arrays.sort(word);
			StringBuilder sb = new StringBuilder();
			for (char c : word) {
				sb.append(c);
			}
			words.add(sb.toString());
		}

		System.out.println(words.size());

	}
}
