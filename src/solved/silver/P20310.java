package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P20310 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] s = br.readLine().toCharArray();

		int zeroCount = 0;
		int oneCount = 0;
		int targetZeroCount = 0;
		int targetOneCount = 0;
		for (char ch : s){
			if (ch == '1') targetOneCount++;
			else targetZeroCount++;
		}
		targetOneCount /= 2;
		targetZeroCount /= 2;

		int zeroStartIndex = s.length - 1;
		int oneStartIndex = 0;

		boolean[] isRemoved = new boolean[s.length];
		while (true){
			if (zeroCount == targetZeroCount && oneCount == targetOneCount){
				break;
			}

			if (s[oneStartIndex] == '1' && oneCount < targetOneCount){
				oneCount++;
				isRemoved[oneStartIndex] = true;
			}
			if (s[zeroStartIndex] == '0' && zeroCount < targetZeroCount){
				zeroCount++;
				isRemoved[zeroStartIndex] = true;
			}

			if (oneStartIndex < s.length-1) oneStartIndex++;
			if (zeroStartIndex > 0) zeroStartIndex--;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length; i++){
			if (!isRemoved[i]){
				sb.append(s[i]);
			}
		}
		System.out.println(sb);
	}
}
