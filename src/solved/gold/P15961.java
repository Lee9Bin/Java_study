package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15961 {
	
	static int N, d, k, c;
	static ArrayList<Integer> foods;
	static int[] visited;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		foods = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			foods.add(Integer.parseInt(br.readLine()));
		}
		visited = new int[d+1];
		int result = 0;
		int left = 0;
		int right = 0;
		
		int size = 1;
		int foodCnt = 1;
		visited[foods.get(left)] += 1;
		
		while(left < N) {
			
			if (size < k) {
				right ++;
				if (right == N) right = 0;
				
				if (visited[foods.get(right)] == 0) {
					foodCnt += 1;
				}
				visited[foods.get(right)] += 1;
				size += 1;
				
			}
			else if (size == k) {
				if (visited[c] == 0) {
					result = Math.max(result, foodCnt + 1);
				}
				else result = Math.max(result, foodCnt);
				
				size -=1;
				visited[foods.get(left)] -= 1;
				if (visited[foods.get(left)] == 0) foodCnt -=1;
				left +=1;
			}

		}
		System.out.println(result);
	}
}
