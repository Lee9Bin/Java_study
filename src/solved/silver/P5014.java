package solved.silver;

import java.util.*;
import java.io.*;

public class P5014 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		//총 F층
		int F = Integer.parseInt(st.nextToken());
		//현재 S층
		int S = Integer.parseInt(st.nextToken());
		//목표 G층
		int G = Integer.parseInt(st.nextToken());
		//U층 위로
		int U = Integer.parseInt(st.nextToken());
		//D층 아래로
		int D = Integer.parseInt(st.nextToken());

		int[] stairs = new int[F+1];
		Arrays.fill(stairs, Integer.MAX_VALUE);
		stairs[S] = 0;
		PriorityQueue<int[]> stairInfo = new PriorityQueue<>((int[] o1, int[] o2) -> {
			return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
		});
		stairInfo.add(new int[] {0, S});
		//[0] 횟수
		//[1] 층
		while (!stairInfo.isEmpty()){
			int[] nowInfo = stairInfo.poll();

			if (nowInfo[1] + U <= F &&stairs[nowInfo[1] + U] > nowInfo[0] + 1){
				stairs[nowInfo[1] + U] = nowInfo[0] + 1;
				stairInfo.add(new int[] {nowInfo[0] + 1, nowInfo[1] + U});
			}

			if (nowInfo[1] - D >= 1 && stairs[nowInfo[1] - D] > nowInfo[0] + 1){
				stairs[nowInfo[1] - D] = nowInfo[0] + 1;
				stairInfo.add(new int[] {nowInfo[0] + 1, nowInfo[1] - D});
			}
		}
		if (stairs[G] != Integer.MAX_VALUE)
			System.out.println(stairs[G]);
		else{
			System.out.println("use the stairs");
		}
	}
}
