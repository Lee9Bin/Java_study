package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 번호, 도착지점
        ArrayList<int[]> game = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = C - 1; j > 0; j--) {
                if (line.charAt(j) != 'F' && line.charAt(j) != '.' && line.charAt(j) != 'S') {
                    game.add(new int[]{line.charAt(j) - '0', j});
                    break;
                }
            }
        }
        game.sort((int[] o1, int[] o2) -> {
            return o2[1] - o1[1];
        });

        int[] result = new int[10];

        int rank = 0;
        int max = Integer.MAX_VALUE;
        for (int[] i : game) {
            if (i[1] < max) {
                rank++;
                max = i[1];
            }
            result[i[0]] = rank;

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);

    }
}
