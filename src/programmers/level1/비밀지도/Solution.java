package programmers.level1.비밀지도;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i<n; i++){
            int cnt = 0;
            answer[i] = "";
            String s1 = "";
            String s2 = "";
            while (cnt < n){
                s1 += Integer.toString(arr1[i] % 2);
                s2 += Integer.toString(arr2[i] % 2);

                arr1[i] = arr1[i]/2;
                arr2[i] = arr2[i]/2;
                cnt +=1;
            }
            System.out.println(s1+" "+s2);

            for (int j = n-1 ; j >= 0; j--){
                if (s1.charAt(j) == '1' || s2.charAt(j) == '1'){
                    answer[i] +="#";
                }
                else if (s1.charAt(j) == '0' && s2.charAt(j) == '0')
                    answer[i] +=" ";
            }
        }
        return answer;
    }
}