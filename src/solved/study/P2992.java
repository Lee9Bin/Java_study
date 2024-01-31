package solved.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1. 문제설명: 문제에서는 정수 X라고 설명하지만 하나의 수열이라고 생각해서
*            각 원소를 뽑아 구성할 수 있는 숫자중 현재 주어진 정수보다 큰 수중 제일 작은 값 출력
 * 2. 코드 로직 및 구현 과정: 재귀를 활용해 모든 경우의 수 구하기
 *
 */

public class P2992 {
    static StringBuilder sb; //출력을 위한

    static char[] num;
    static boolean[] visited;
    static int result;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //정수 X를 담는다.
        result = Integer.parseInt(br.readLine());
        //정수 X를 쪼개서 배열에 담는다.
        num = String.valueOf(result).toCharArray();
        //방문 했는지 체크 - why? 이미 뽑았던 친구는 뽑지 않기 위해
        visited = new boolean[num.length];
        //정렬을 하는 이유는 순차적으로 접근해서 현재 X보다 큰 값 만나는 순간 끝내기 위해
        Arrays.sort(num);

        sb = new StringBuilder();
        makeNum(0);
        System.out.println(ans);
    }

    public static void makeNum(int cnt){
        if (ans !=0){ // 현재 최종 정답이 0이 아니면 모든 재귀 종료
            return;
        }
        if (cnt == num.length && result < Integer.parseInt(sb.toString())){ // 현재 깊이가 X와 같고 result보다 크면 바로 저장
            ans = Integer.parseInt(sb.toString());
            return;
        }

        for (int i = 0; i < num.length; i++){
            if (visited[i] == false) {
                sb.append(num[i] - '0');
                visited[i] = true;
                makeNum(cnt+1);
                visited[i] = false;
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }
}
