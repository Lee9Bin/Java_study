package solved.gold;

import java.io.*;
import java.util.*;

public class P13913 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayDeque<int[]> heap = new ArrayDeque<>();

		heap.add(new int[] {0, N, -1});

		int[][] dp = new int[100001][3];
		Arrays.fill(dp, new int[] {Integer.MAX_VALUE, 0, 0});
		dp[N] =new int[] {0, N, -1};

		int[] result = null;

		while(!heap.isEmpty()){
			int[] now = heap.pollFirst();

			int nowNum = now[1];
			if (nowNum == K) {
				result = now;
				break;
			}
			int count = now[0];


			if (nowNum + 1 <= 100000 && dp[nowNum + 1][0] > count + 1){
				dp[nowNum + 1] = new int[] {count +1, nowNum + 1, nowNum};
				heap.add(new int[] {count +1, nowNum + 1,nowNum});
			}

			if (nowNum -1  >= 0 && dp[nowNum - 1][0] > count + 1){
				dp[nowNum - 1] = new int[] {count +1, nowNum - 1, nowNum};
				heap.add(new int[] {count +1, nowNum - 1,nowNum});
			}

			if (nowNum * 2 <= 100000 && dp[nowNum * 2][0] > count + 1){
				dp[nowNum * 2] = new int[] {count + 1, nowNum * 2, nowNum};
				heap.add(new int[] {count +1, nowNum * 2,nowNum});
			}

		}
		StringBuilder sb = new StringBuilder();
		System.out.println(result[0]);
		while (true){
			sb.append(result[1]).append(" ");
			if (result[2] == -1) break;
			result = dp[result[2]];
		}
		st = new StringTokenizer(sb.toString());
		String[] temp = new String[st.countTokens()];
		int index = 0;
		while(st.hasMoreTokens()){
			temp[index++] = st.nextToken();
		}
		sb = new StringBuilder();
		for (int i = temp.length-1; i >=0; i-- ){
			sb.append(temp[i]).append(" ");
		}
		System.out.println(sb);
	}
}
