import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2628 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int cal = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> rows = new ArrayList<>();
		ArrayList<Integer> cals = new ArrayList<>();
		
		rows.add(0);
		cals.add(0);
		rows.add(row);
		cals.add(cal);
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int commend = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			if (commend != 0) rows.add(len);
			else cals.add(len);
		}
		
		
		Collections.sort(rows);
		Collections.sort(cals);
		int maxRow = 0;
		int maxcal = 0;
		for (int i = 0; i < rows.size()-1; i++) {
			maxRow = Math.max(maxRow, rows.get(i+1) - rows.get(i));
		}
		
		for (int i = 0; i < cals.size()-1; i++) {
			maxcal = Math.max(maxcal, cals.get(i+1) - cals.get(i));
		}
		System.out.println(maxRow * maxcal);
	}
}
