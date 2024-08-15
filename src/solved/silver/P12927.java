package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] lights = br.readLine().toCharArray();

        int cnt = 0;
        for (int i = 0; i < lights.length; i++) {
            if (lights[i] == 'Y') {
                cnt++;
                for (int j = i; j < lights.length; j += (i + 1)) {
                    if (lights[j] == 'Y') lights[j] = 'N';
                    else if (lights[j] == 'N') lights[j] = 'Y';
                }
            }
        }
        for (int i = 0; i < lights.length; i++) {
            if (lights[i] == 'Y') {
                cnt = -1;
            }
        }

        System.out.println(cnt);
    }
}
