package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());

		if (N == 0) {
			System.out.println("NO");
			return;
		}
		while (N > 0) {
			if (N % 3 == 2) {
				System.out.println("NO");
				return;
			}
			N /= 3;
		}

		System.out.println("YES");
	}
}
