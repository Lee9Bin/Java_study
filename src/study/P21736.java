package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제설명: 대표적인 DFS, BFS 미로 탐색 유형의 문제
 * 풀이방법: BFS를 통해 현재 좌표에서 P에 해당하는 좌표에 도달할 수 있는지 카운팅!
 */


public class P21736 {

    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};
    static int N, M, result;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        //방문한 적인 있는지 체크하기 위한
        visited = new boolean[N][M];

        //'I' 위치 찾기
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            for(int j = 0; j <M; j++) {
                if (map[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        //탐색 시작
        bfs(x, y);
        //탐색 후 0이면 외톨이 ㅜㅜ
        System.out.println(result == 0 ? "TT" : result);
    }

    public static void bfs(int x, int y){
        //방문 순서를 관리할 큐 생성
        Queue<int[]> que = new ArrayDeque<>();
        //현재 'I'의 위치 추가
        que.add(new int[] {x, y});
        visited[x][y] = true;

        while (!que.isEmpty()){
            int[] now = que.poll();
            int nowX = now[0];
            int nowY = now[1];

            //도연이는 상 하 좌 우로 이동이 가능
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                //다음 좌표가 범위안에 있는지, 갈수 있는 좌표인지, 방문 했는지
                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && map[nextX][nextY] !='X' &&!visited[nextX][nextY]) {
                    // 방문 체크
                    visited[nextX][nextY] = true;
                    // 친구가 있다면 카운팅
                    if(map[nextX][nextY] == 'P') result ++;
                    // 벽이 아닌 곳은 이동이 가능 하므로 'O' 'P'인 좌표 추가
                    que.add(new int[] {nextX, nextY});
                }
            }
        }
    }
}
