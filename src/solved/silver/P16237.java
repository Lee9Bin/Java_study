package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16237 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int baskets = 0;

		baskets += E;

		baskets += D;
		if (A >= D)
			A -= D;
		else
			A = 0;

		int pair3with2 = Math.min(C, B);
		baskets += pair3with2;
		C -= pair3with2;
		B -= pair3with2;

		baskets += C;
		if (A >= 2 * C)
			A -= 2 * C;
		else
			A = 0;

		baskets += (B / 2);
		int remainderB = B % 2;
		int pairsOfTwo = B / 2;
		int canFillWithOnes = Math.min(pairsOfTwo, A);
		A -= canFillWithOnes;

		if (remainderB == 1) {
			baskets += 1;
			int canPutOne = Math.min(3, A);
			A -= canPutOne;
		}

		baskets += (A / 5);
		if (A % 5 != 0)
			baskets += 1;

		System.out.println(baskets);
	}
}
