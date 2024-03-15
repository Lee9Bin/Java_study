package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//XXXXXX
public class P1343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] sortList = new String[n];
		String[] originList = new String[n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			sortList[i] = s;
			originList[i] = s;
		}
		Arrays.sort(sortList);

		boolean incre = true;
		boolean decre = true;

		for (int i = 0; i < n; i++) {
			if (!sortList[i].equals(originList[i])) {
				incre = false;
			}
			if (!sortList[n - i - 1].equals(originList[i])) {
				decre = false;
			}
		}

		if (incre) {
			System.out.println("INCREASING");
			return;
		} else if (decre) {
			System.out.println("DECREASING");
		} else {
			System.out.println("NEITHER");
		}
	}
}
