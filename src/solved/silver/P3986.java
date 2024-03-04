package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P3986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int total = 0;
		for (int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			stack.add(ch[0]);
			for (int j = 1; j < ch.length; j++) {
				if (stack.isEmpty()) {
					stack.add(ch[j]);
					continue;
				}
				if (stack.peek() == ch[j]) {
					stack.pop();
				} else {
					stack.add(ch[j]);
				}
			}
			if (stack.isEmpty())
				total++;

		}
		System.out.println(total);
	}
}
