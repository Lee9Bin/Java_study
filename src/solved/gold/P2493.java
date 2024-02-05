package ws.daily06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2493 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] s = new int[n];
		for(int i = 0 ; i < n; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		
		int[] result = new int[n];
		for (int i = n-1; i >= 0; i--) {
			if (stack.isEmpty()) {
				stack.add(i);				
			}
			else {
				if(s[stack.peek()] < s[i]) {
					while (!stack.isEmpty()) {
						if (s[stack.peek()] >= s[i]) {
							break;
						}
						result[stack.pop()] = i+1;
					}
				}
				stack.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i : result) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);

	}
}
