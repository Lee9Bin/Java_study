package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14627 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] sList = new int[S];

		for (int i = 0; i < S; i++){
			sList[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(sList);
		int start = 1;
		int end = sList[S-1];

		long result = 1;
		while(true){
			if (start > end) break;
			int mid = (start + end) / 2;

			long total = 0;
			for (int i = 0; i < S; i++){
				total += sList[i] / mid;
			}

			if (total < C){
				end = mid - 1;
			}
			else{
				result = Math.max(mid, result);
				start = mid +1;
			}
		}
		long total = 0;
		int cnt = 0;
		for (int i : sList) {
			if (cnt < C){

				total += i - ((i / result) * result);
				cnt += i / result;
				if (cnt > C){
					total += (cnt - C) * result;
				}
			}
			else{
				total += i;
			}
		}
		System.out.println(total);
	}
}
