package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16198 {
	static int[] enegeys;
	static boolean[] visited;
	static int N;
	static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		enegeys = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i ++) {
			enegeys[i] = Integer.parseInt(st.nextToken());
		}
		back(0,0);
		System.out.println(result);
	}
	public static void back(int cnt, int total) {
		if (cnt == N-2) {
			result = Math.max(result, total);
			return;
		}
		
		for (int i = 1; i < N-1; i ++) {
			if (!visited[i]) {
				visited[i] = true;
				int leftIndex = i;
				for (int j = i-1 ; j >= 0; j--) {
					if(!visited[j]) {
						leftIndex = j;
						break;
					}
				}
				int rigtht = i;
				for (int j = i+1 ; j<N; j++) {
					if(!visited[j]) {
						rigtht = j;
						break;
					}
				}
				back(cnt + 1, total + (enegeys[leftIndex] * enegeys[rigtht]));
				visited[i] = false;
			}
		}
	}
}
