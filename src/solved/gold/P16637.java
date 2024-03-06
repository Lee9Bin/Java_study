package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P16637 {

	static int N, result;
	static String[] maths;
	static ArrayList<String> subList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] sub = br.readLine().toCharArray();
		maths = new String[N];
		for (int i = 0; i < N; i++) {
			maths[i] = sub[i] + "";
		}

		subList = new ArrayList<>();

		result = Integer.MIN_VALUE;
		dfs(0, 0, new ArrayList<>());
		System.out.println(result);
	}

	public static void dfs(int cnt, int start, ArrayList<String> subList) {
		if (cnt != start)
			return;
		if (cnt == N) {
			int total = Integer.parseInt(subList.get(0));
			for (int i = 1; i < subList.size(); i += 2) {
				if (subList.get(i).equals("-")) {
					total -= Integer.parseInt(subList.get(i + 1));
				}
				if (subList.get(i).equals("+")) {
					total += Integer.parseInt(subList.get(i + 1));
				}
				if (subList.get(i).equals("*")) {
					total *= Integer.parseInt(subList.get(i + 1));
				}
			}
			result = Math.max(result, total);
			return;
		}

		for (int i = start; i < N; i++) {
			int newChar = 100;
			if (!maths[i].equals("-") && !maths[i].equals("+") & !maths[i].equals("*")) { // 숫자일때
				// 괄호 경우
				if (i < N - 2) {
					if (maths[i + 1].equals("-")) {
						newChar = Integer.parseInt(maths[i]) - Integer.parseInt(maths[i + 2]);
					}
					if (maths[i + 1].equals("+")) {
						newChar = Integer.parseInt(maths[i]) + Integer.parseInt(maths[i + 2]);
					}
					if (maths[i + 1].equals("*")) {
						newChar = Integer.parseInt(maths[i]) * Integer.parseInt(maths[i + 2]);
					}
					subList.add(Integer.toString(newChar));
					dfs(cnt + 3, i + 3, subList);
					subList.remove(subList.size() - 1);
				}
			}
			subList.add(maths[i]);
			dfs(cnt + 1, i + 1, subList);
			subList.remove(subList.size() - 1);
		}
	}
}
