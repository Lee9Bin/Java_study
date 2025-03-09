package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14468 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int[] first = new int[26];
		int[] second = new int[26];
		int count = 0;

		for (int i = 0; i < 52; i++) {
			int idx = str.charAt(i) - 'A';
			if (first[idx] == 0)
				first[idx] = i + 1;
			else
				second[idx] = i + 1;
		}

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				if (first[i] < first[j] && first[j] < second[i] && second[i] < second[j]) {
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
