package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P12109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] scientists = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scientists[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scientists);

        int hIndex = 0;
        for (int i = 0; i < n; i++) {
            int hCandidate = n - i;
            if (scientists[i] >= hCandidate) {
                hIndex = hCandidate;
                break;
            }
        }
        System.out.println(hIndex);
    }
}
