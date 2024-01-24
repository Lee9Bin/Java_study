package solved.study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1.문제설명: 1 5 10 50중에 중복을 허용해 n개를 뽑아 서로 다른 합의 갯수 구하기
 * 2.코드 로직 및 구현과정: 트리 가지치기 그려보기 -> 백트래킹(종료 조건: depth == n이 되면 종료)
 * 3.어려웠던 점: 단순히 모든 경우의 수를 구하려 하다보니 시간초과 발생 가능성이 생겼다.
 *   for문에서 index 시작지점을 지정 why? 중복조합에서 경우의수를 뽑을 때를 생각해보면!
 */
public class P16922 {
    static int ans = 0;
    static int[] list = new int[1001];
    static int[] score = {1,5,10,50};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        back(0, 0, 0, n);
        System.out.println(ans);
    }

    static void back(int index, int total, int depth, int end) {
        if (depth == end) {
            if (list[total] == 0){
                list[total] = 1;
                ans += 1;
            }
            return;
        }
        for (int i = index; i < 4; i++) {
            back(i, total+score[i],depth +1, end);
        }
    }
}