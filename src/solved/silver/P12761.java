package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P12761 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        PriorityQueue<int[]> heapq = new PriorityQueue<>((int[] o1, int[] o2) -> {
            return o1[1] - o2[1];
        });
        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        // 현재 위치, 이동 횟수
        heapq.add(new int[]{N, 0});

        while (!heapq.isEmpty()) {
            int[] now = heapq.poll();
            int x = now[0];
            int count = now[1];

            if (visited[x] < count) continue;
            visited[x] = count;

            int[] next1 = makeMove(x, count, -1);
            if (checkRange(next1[0]) && next1[1] < visited[next1[0]]) {
                heapq.add(next1);
                visited[next1[0]] = next1[1];
            }

            int[] next2 = makeMove(x, count, 1);
            if (checkRange(next2[0]) && next2[1] < visited[next2[0]]) {
                heapq.add(next2);
                visited[next2[0]] = next2[1];
            }

            int[] nextPlusA = makeMove(x, count, A);
            if (checkRange(nextPlusA[0]) && nextPlusA[1] < visited[nextPlusA[0]]) {
                heapq.add(nextPlusA);
                visited[nextPlusA[0]] = nextPlusA[1];
            }

            int[] nextMinusA = makeMove(x, count, -A);
            if (checkRange(nextMinusA[0]) && nextMinusA[1] < visited[nextMinusA[0]]) {
                heapq.add(nextMinusA);
                visited[nextMinusA[0]] = nextMinusA[1];
            }

            int[] nextPlusB = makeMove(x, count, B);
            if (checkRange(nextPlusB[0]) && nextPlusB[1] < visited[nextPlusB[0]]) {
                heapq.add(nextPlusB);
                visited[nextPlusB[0]] = nextPlusB[1];
            }

            int[] nextMinusB = makeMove(x, count, -B);
            if (checkRange(nextMinusB[0]) && nextMinusB[1] < visited[nextMinusB[0]]) {
                heapq.add(nextMinusB);
                visited[nextMinusB[0]] = nextMinusB[1];
            }

            int[] nextMultiA = makeMultiMove(x, count, A);
            if (checkRange(nextMultiA[0]) && nextMultiA[1] < visited[nextMultiA[0]]) {
                heapq.add(nextMultiA);
                visited[nextMultiA[0]] = nextMultiA[1];
            }

            int[] nextMultiB = makeMultiMove(x, count, B);
            if (checkRange(nextMultiB[0]) && nextMultiB[1] < visited[nextMultiB[0]]) {
                heapq.add(nextMultiB);
                visited[nextMultiB[0]] = nextMultiB[1];
            }

        }
        System.out.println(visited[M]);

    }

    public static int[] makeMove(int x, int count, int next) {
        return new int[]{x + next, count + 1};
    }

    public static int[] makeMultiMove(int x, int count, int next) {
        return new int[]{x * next, count + 1};
    }

    public static boolean checkRange(int x) {
        return 0 <= x && x < 100001;
    }

}
