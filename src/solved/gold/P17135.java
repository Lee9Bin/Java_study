package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P17135 {
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static int[][] dis;
	static ArrayList<int[]> enemys;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		enemys = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) enemys.add(new int[] {i,j}); 
			}
		}
		
		int ans = Integer.MIN_VALUE;
		for(int i = 0; i < M; i++) {
			for (int j = i + 1 ; j < M; j ++) {
				for (int k = j + 1; k < M; k++) {
					//궁수 조합 끝
					int result = 0;
					boolean[] visited = new boolean[enemys.size()];
					
					for (int round = N; round>=1; round --) {// 각 라운드
						int[] findEnemy = {-1,-1,-1};
						int minDis = Integer.MAX_VALUE;
						int y = Integer.MAX_VALUE;
						for (int num = 0; num < enemys.size(); num++) { // 1 궁수 -> 거리가 가장 작은 값을 찾아
							int nowDis = Math.abs(round - enemys.get(num)[0]) + Math.abs(i - enemys.get(num)[1]);
							if (minDis >= nowDis && !visited[num] && nowDis <= D && enemys.get(num)[0] < round) {
								if (minDis > nowDis) {
									minDis = nowDis;
									y = enemys.get(num)[1];									
									findEnemy[0] = num;
								}
								else {
									if (y > enemys.get(num)[1]) {
										y = enemys.get(num)[1];
										findEnemy[0] = num;
									} 
								}
							}
						}
						
						minDis = Integer.MAX_VALUE;
						y = Integer.MAX_VALUE;
						for (int num = 0; num < enemys.size(); num++) { // 1 궁수 -> 거리가 가장 작은 값을 찾아
							int nowDis = Math.abs(round - enemys.get(num)[0]) + Math.abs(j - enemys.get(num)[1]);
							if (minDis >= nowDis && !visited[num] && nowDis <= D && enemys.get(num)[0] < round) {
								if (minDis > nowDis) {
									minDis = nowDis;
									y = enemys.get(num)[1];									
									findEnemy[1] = num;
								}
								else {
									if (y > enemys.get(num)[1]) {
										y = enemys.get(num)[1];
										findEnemy[1] = num;
									} 
								}
							}
						}
						
						minDis = Integer.MAX_VALUE;
						y = Integer.MAX_VALUE;
						for (int num = 0; num < enemys.size(); num++) { // 1 궁수 -> 거리가 가장 작은 값을 찾아
							int nowDis = Math.abs(round - enemys.get(num)[0]) + Math.abs(k - enemys.get(num)[1]);
							if (minDis >= nowDis && !visited[num] && nowDis <= D && enemys.get(num)[0] < round) {
								if (minDis > nowDis) {
									minDis = nowDis;
									y = enemys.get(num)[1];									
									findEnemy[2] = num;
								}
								else {
									if (y > enemys.get(num)[1]) {
										y = enemys.get(num)[1];
										findEnemy[2] = num;
									} 
								}
							}
						}
						
						for (int index : findEnemy) {
							if (index == -1) continue;
							visited[index] = true;
						}
					}
					for (boolean check : visited) {
						if (check) result +=1;
					}
					ans = Math.max(result, ans);
				}
			}
		}
		System.out.println(ans);
	}
}
