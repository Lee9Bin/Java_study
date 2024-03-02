package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P5644 {

    static int[] dx = {0,0,1,0,-1};
    static int[] dy = {0,-1,0,1,0};

    static int M, A, total;
    static ArrayList<int[]> batteries;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int testNum = 1; testNum <= testCase; testNum++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 이동 정보 갯수
            A = Integer.parseInt(st.nextToken()); // 배터리 갯수

            StringTokenizer Amove = new StringTokenizer(br.readLine()); // A의 이동 정보
            StringTokenizer Bmove = new StringTokenizer(br.readLine()); // B의 이동 정보


            batteries = new ArrayList<>();
            for (int i = 0; i < A; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken()); // 범위
                int p = Integer.parseInt(st.nextToken()); // 충전량
                batteries.add(new int[] {x,y,c,p});
            }
            batteries.sort((int[] o1, int[] o2) -> {
                return o2[3] - o1[3];
            });

            int Ax = 1;
            int Ay = 1;

            int Bx = 10;
            int By = 10;
            total = 0;
            startLocation(Ax, Ay);
            startLocation(Bx, By);
            //시작 지점

            for (int i = 1; i<M+1; i++){
                int Acommend = Integer.parseInt(Amove.nextToken());
                int Bcommend = Integer.parseInt(Bmove.nextToken());
                Ax = Ax + dx[Acommend];
                Ay = Ay + dy[Acommend];
                Bx = Bx + dx[Bcommend];
                By = By + dy[Bcommend];
                nowLocation(Ax, Ay, Bx, By);
            }

            sb.append("#").append(testNum).append(" ").append(total).append("\n");
        }
        System.out.println(sb);
    }

    public static void startLocation(int x, int y){
        int maxCharge = 0;
        for(int[] battery : batteries){
            int dis = Math.abs(x-battery[0]) + Math.abs(y - battery[1]);
            if (dis <= battery[2]) maxCharge = Math.max(maxCharge, battery[3]);
        }
        total += maxCharge;
    }

    public static void nowLocation(int Ax, int Ay, int Bx, int By){

        boolean[] ACanCharge = new boolean[batteries.size()];
        boolean[] BCanCharge = new boolean[batteries.size()];
        int aCount = 0;
        int bCount = 0;

        for(int i = 0; i < batteries.size(); i++){
            int[] battery = batteries.get(i);
            int Adis = Math.abs(Ax-battery[0]) + Math.abs(Ay - battery[1]);
            int Bdis = Math.abs(Bx-battery[0]) + Math.abs(By - battery[1]);
            if(Adis <= battery[2]){
                aCount++;
                ACanCharge[i] = true;
            }
            if(Bdis <= battery[2]){
                bCount++;
                BCanCharge[i] = true;
            }
        }
        int maxC = 0;

        if (aCount == 0 && bCount == 0){
            return;
        }

        if (bCount == 0){
            for(int i = 0; i < batteries.size(); i++){
                if (ACanCharge[i]) maxC = Math.max(maxC, batteries.get(i)[3]);
            }
            total += maxC;
            return;
        }
        if (aCount == 0){
            for(int i = 0; i < batteries.size(); i++){
                if (BCanCharge[i]) maxC = Math.max(maxC, batteries.get(i)[3]);
            }
            total += maxC;
            return;
        }

        for (int i = 0; i < batteries.size(); i++){
            if(!ACanCharge[i]) continue;
            int tempA = batteries.get(i)[3];
            for (int j = 0; j < batteries.size(); j++){
                if (!BCanCharge[j]) continue;
                int tempB = batteries.get(j)[3];

                if (i != j){
                    maxC = Math.max(tempA+tempB, maxC);
                }
                else{
                    maxC = Math.max(maxC, tempA);
                }
            }
        }
        total += maxC;

    }
}
