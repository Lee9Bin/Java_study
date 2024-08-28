package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // index, 내구도, 로봇 유무(0, 1) , 다음 로봇 인덱스 위치
        ArrayList<int[]> up = new ArrayList<>();
        ArrayList<int[]> down = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        // 내구도, 로봇 유무?
        for (int i = 0; i < N; i++) {
            up.add(new int[]{Integer.parseInt(st.nextToken()), 0});
        }
        for (int i = N; i < 2 * N; i++) {
            down.add(0, new int[]{Integer.parseInt(st.nextToken()), 0});
        }

        int cnt = 0;
        int result = 0;
        while (true) {
            result++;
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            int[] upLast = up.remove(N - 1);
            if (upLast[1] == 1) upLast[1] = 0;
            down.add(upLast);

            int[] downFirst = down.remove(0);
            up.add(0, downFirst);

            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            // 	1. 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            for (int i = N - 2; i >= 0; i--) {
                if (i == N - 2) {
                    if (up.get(i + 1)[0] > 0 && up.get(i)[1] == 1) {
                        int[] now = up.get(i);
                        now[1] = 0;
                        up.get(i + 1)[0] -= 1;
                        if (up.get(i + 1)[0] == 0) cnt += 1;
                    }
                } else {
                    if (up.get(i + 1)[1] == 0 && up.get(i)[1] == 1 && up.get(i + 1)[0] > 0) {
                        up.get(i + 1)[1] = 1;
                        up.get(i)[1] = 0;
                        up.get(i + 1)[0] -= 1;
                        if (up.get(i + 1)[0] == 0) cnt += 1;
                    }
                }
            }
            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            int upFirst[] = up.get(0);
            if (upFirst[0] > 0) {
                upFirst[0] -= 1;
                upFirst[1] = 1;
                if (upFirst[0] == 0) cnt++;
            }
            // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            if (cnt >= K) break;
        }
        System.out.println(result);
    }
}
