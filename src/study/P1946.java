package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1946 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		
		for (int testNum = 1; testNum <= tests; testNum++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] peoples = new int[n][2];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				peoples[i] = new int[] {a,b};
			}
			
			Arrays.sort(peoples, (int[] o1, int[] o2) -> {
				return o1[0] != o2[0] ? o1[0]-o2[0] : o1[1] - o2[1];
			});
			
			int nowPoint = peoples[0][1];
			int result = 1;
			for (int i = 1; i < n; i++) {
				if (nowPoint > peoples[i][1]) {
					result ++;
					nowPoint = peoples[i][1];
				}
			}
			System.out.println(result);
			
		}
	}
}
