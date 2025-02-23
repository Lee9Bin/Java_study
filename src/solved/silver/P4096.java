package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4096 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = br.readLine();
			if (s.equals("0"))
				break;

			int len = s.length();
			int num = Integer.parseInt(s);
			int count = 0;

			while (true) {
				String temp = String.valueOf(num + count);
				StringBuilder padded = new StringBuilder();
				for (int i = 0; i < len - temp.length(); i++) {
					padded.append('0');
				}
				padded.append(temp);
				String candidate = padded.toString();

				boolean isPal = true;
				for (int i = 0; i < len / 2; i++) {
					if (candidate.charAt(i) != candidate.charAt(len - 1 - i)) {
						isPal = false;
						break;
					}
				}
				if (isPal)
					break;

				count++;
			}

			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}
