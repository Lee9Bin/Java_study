package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P31474 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		long up = 1;

		long count = n/2;
		while (n > 0){
			for (int i = 1; i <= 2; i++){
				up *= n;
				n--;
			}
			up /= 2;
			up /= count;
			count--;
		}
		System.out.println(up);
	}
}
