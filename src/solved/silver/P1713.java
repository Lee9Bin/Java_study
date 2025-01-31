package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        HashMap<Integer, int[]> pictures = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (pictures.containsKey(num)) {
                int[] info = pictures.get(num);
                info[0] += 1;
                pictures.put(num, info);
            } else {
                if (pictures.size() < N) pictures.put(num, new int[]{1, i});
                else {
                    int target = 0;
                    int count = Integer.MAX_VALUE;
                    int old = Integer.MAX_VALUE;
                    for (Integer integer : pictures.keySet()) {
                        int[] info = pictures.get(integer);
                        if (count >= info[0]) {
                            if (count == info[0]) {
                                if (old > info[1]) {
                                    target = integer;
                                    old = info[1];
                                }
                            } else {
                                target = integer;
                                count = info[0];
                                old = info[1];
                            }
                        }
                    }
                    pictures.remove(target);
                    pictures.put(num, new int[]{1, i});
                }
            }
        }

        ArrayList<int[]> result = new ArrayList<>();
        for (Integer integer : pictures.keySet()) {
            int[] info = pictures.get(integer);
            result.add(new int[]{info[0], info[1], integer});
        }

        result.sort((int[] o1, int[] o2) -> {
            return o1[2] - o2[2];
        });


        StringBuilder sb = new StringBuilder();
        for (int[] ints : result) {
            sb.append(ints[2]).append(" ");
        }
        System.out.println(sb);
    }
}
