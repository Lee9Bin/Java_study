package solved.gold;

import java.io.*;
import java.util.*;

public class P2470 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] water = new int[N];
		for (int i = 0 ; i < N; i++){
			water[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(water);

		int start = 0;
		int end = N-1;
		int a = 0;
		int b = 0;
		int cost = Integer.MAX_VALUE;
		//-99 -2 -1 4 98 101
		//111 100 95 1 1 11
		while (true){
			if (start >= end) break;
			int nowCost = water[start] + water[end];
			if (Math.abs(nowCost) < Math.abs(cost)){
				cost = Math.abs(nowCost);
				a = water[start];
				b = water[end];
			}
			if (nowCost > 0){
				end --;
			}
			else{
				start++;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(a).append(" ").append(b);
		System.out.println(sb);
	}
}
