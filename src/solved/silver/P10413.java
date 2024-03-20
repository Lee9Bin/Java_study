package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P10413 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int testNum = 0; testNum < t; testNum++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			ArrayList<Integer> student = new ArrayList<>();
			for (int i = 0 ; i < 20; i++) {
				int height = Integer.parseInt(st.nextToken());
				student.add(height);
			}
			
			int total = 0;
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < i; j++) {
					if (student.get(i) < student.get(j)) {
						int now = student.remove(i);
						student.add(j, now);
						total += i - j;
						break;
					}
				}
			}
			System.out.println(n + " " +total);
		}
		
	}
}
