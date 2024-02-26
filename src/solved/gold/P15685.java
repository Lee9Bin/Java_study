package solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제설명: 드래곤 커브는 시작점, 시작 방향, 세대를 가지고 있다.
 *        이때 다음 세대의 드래곤 커브는 이전 세대의 드래곤 커브의 정보를 토대로 만들어진다.
 * 접근방법: 문제에 주어진 드래곤 커브의 특징을 통해 규칙을 찾으려 노력했다.
 *        n-1세대의 방향 정보를 토대로 n세대의 직선이 이어서 그려진다.
 *        ex) v / v < / v < ^ < ...
 */
public class P15685 {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int N, result;
    static int[][] map = new int[101][101];
    static ArrayList<ArrayList<Integer>> dList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){ //n개 만큼
            StringTokenizer st = new StringTokenizer(br.readLine());

            dList = new ArrayList<>(); // 각 세대의 방향을 저장하기 위한 리스트

            int x = Integer.parseInt(st.nextToken()); //시작위치 x좌표
            int y = Integer.parseInt(st.nextToken()); //시작위치 y좌표
            int d = Integer.parseInt(st.nextToken()); //시작 방향
            int g = Integer.parseInt(st.nextToken()); //몇세대 인지
            dList.add(new ArrayList<>()); // 0세대 추가
            dList.get(0).add(d); // 0세대 드래곤 커브 방향 저장

            //이전세대 방향을 가지고 현재 세대의 방향을 만든다.
            for (int j = 1; j <= g; j ++){
                dList.add(new ArrayList<>()); //현재 세대 추가

                int size = dList.get(j-1).size(); //이전 세대의 사이즈
                //기본적으로 이전 세대의 방향을 기반으로 그려지므로 이전의 방향 정보 그대로 저장
                for(int k = 0; k < size; k++){
                    dList.get(j).add(dList.get(size).get(k));
                }

                // v < ^ >
                //끝점을 기준으로 시계방향으로 회전하므로 이전의 방향 정보를 거꾸로 탐색하면서 방향 + 1 (90도 회전)
                for(int k = size-1; k >=0 ; k--){
                    dList.get(j).add( (dList.get(size).get(k) + 1) %4);
                }
            }


            map[x][y] = 1; //시작 지점
            //최종 세대를 바탕으로 드래곤 커브 그리기
            for(int j = 0; j < dList.get(g).size(); j ++){
                int nextX = x + dx[dList.get(g).get(j)];
                int nextY = y + dy[dList.get(g).get(j)];
                map[nextX][nextY] = 1;
                x = nextX;
                y = nextY;
            }
        }

        //모든 드래곤 커브를 그린 후 각 꼭지점이 모두 1인 것 찾기
        for(int j = 0; j < 100; j++){
            for (int k = 0; k < 100; k++){
                    if (map[j][k] == 1 && map[j+1][k] == 1 && map[j][k+1] == 1 && map[j+1][k+1] == 1){
                        result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
