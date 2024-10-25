package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		long start = Integer.parseInt(st.nextToken());
		long end = Integer.parseInt(st.nextToken());

		long result = 0;

		for (int i = 0; i < N-1; i++){
			st = new StringTokenizer(br.readLine());
			long nextStart = Integer.parseInt(st.nextToken());
			long nextEnd = Integer.parseInt(st.nextToken());
			if (nextStart <= end && end < nextEnd) end = nextEnd;
			else if (nextStart > end) {
				result += end - start;
				start = nextStart;
				end = nextEnd;
			}
		}
		result += end - start;
		System.out.println(result);
	}
}