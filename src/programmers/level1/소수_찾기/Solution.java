package programmers.level1.소수_찾기;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] prim = new boolean[1000001];
        for (int i = 2; i < 1000001; i++){
            if(prim[i] == false){
                for (int j = i+i; j<1000001; j+=i){
                    if (prim[i] == false)
                        prim[j] = true;
                }
            }
        }
        System.out.println(prim[5]);
        for (int i = 2; i<n+1; i++){
            if (prim[i]==false){
                answer +=1;
            }
        }

        return answer;
    }
}