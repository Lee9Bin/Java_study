package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int result = 0;
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int dis = y - x;

			int target = (int)Math.sqrt(dis);

			result = 2 * target - 1;
			if (Math.sqrt(dis) != target) {
				if (dis <= target * target + target) {
					result += 1;
				} else {
					result += 2;
				}
			}
			System.out.println(result);
		}
	}
}
