package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test = 1; test <= testCase; test++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			long result = 0;
			int maxPrice = 0;
			
			for (int i = n-1; i >=0; i--) {
				if (maxPrice < nums[i]) {
					maxPrice = nums[i];
					continue;
				}
				else {
					result += (maxPrice-nums[i]);
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
