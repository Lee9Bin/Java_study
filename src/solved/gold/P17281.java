package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17281 {
	
	static int[] order;
	static boolean[] visited;
	static int N, total;
	static int game[][];
	static BufferedReader br;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		order = new int[9];
		visited = new boolean[9];
		
		N = Integer.parseInt(br.readLine());
		game = new int[N][9];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		makeOrder(0);
		
		System.out.println(total);
	}
	
	public static void makeOrder(int cnt) {
		if (cnt == 9) {
			//줄세우기 끝
			playBall();
			return;
		}
			
		if (cnt == 3) {
			order[3] = 0;
			makeOrder(cnt + 1);
			return;
			
		}
		for (int i = 1; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				order[cnt] = i;
				makeOrder(cnt+1);
				visited[i] = false;					
			}
		}
	}
	
	public static void playBall() {
		
		int idx = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {
			Queue<Integer> que = new ArrayDeque<>(); 
			int outCount = 0;
			while(true) {
//				System.out.println(i + " "  + idx);
				if (outCount == 3) break;
				if (game[i][order[idx]] == 1) {
					int size = que.size();
					for (int j = 0; j < size; j++) {
						int newInfo = que.poll() + 1;
						if (newInfo >= 4) {
							result ++;
							continue;
						} 
						que.add(newInfo);
					}
					que.add(1);
				}
				
				if (game[i][order[idx]] == 2) {
					int size = que.size();
					for (int j = 0; j < size; j++) {
						int newInfo = que.poll() + 2;
						if (newInfo >= 4) {
							result ++;
							continue;
						} 
						que.add(newInfo);
					}
					que.add(2);
				}
				if (game[i][order[idx]] == 3) {
					int size = que.size();
					for (int j = 0; j < size; j++) {
						int newInfo = que.poll() + 3;
						if (newInfo >= 4) {
							result ++;
							continue;
						} 
						que.add(newInfo);
					}
					que.add(3);
				}
				if (game[i][order[idx]] == 4) {
					result += 1;
					result += que.size();
					que.clear();
				}
				if (game[i][order[idx]] == 0) {
					outCount ++;
				}
				idx ++;
				idx %= 9;
			}
			
		}

		total = Math.max(result, total);
	}
}
