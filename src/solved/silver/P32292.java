package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P32292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder S = new StringBuilder(br.readLine());
			int index = 0;

			while (index < S.length() - 2) {
				char target = S.charAt(index);
				if (target == 'A') {
					boolean check = true;
					for (int k = index + 1; k < index + 3; k++) {
						char now = S.charAt(k);
						if (now == 'A')
							check = false;
					}

					if (check) {
						S.replace(index, index + 3, "BA");
						index = 0;
						continue;
					}
				}
				index++;
			}
			System.out.println(S);
		}

	}
}
