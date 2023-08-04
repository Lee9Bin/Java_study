package programmers.level1.숫자_짝궁;

public class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] xarr = new int[10];
        int[] yarr = new int[10];
        for (String a : X.split("")){
            xarr[Integer.parseInt(a)] += 1;
        }
        for (String a : Y.split("")){
            yarr[Integer.parseInt(a)] += 1;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 9; i>=0; i--){
            while (xarr[i] > 0 && yarr[i] > 0){
                sb.append(i);
                xarr[i] -=1;
                yarr[i] -=1;
            }
        }
        if ((sb.toString()).equals("")){
            return "-1";
        }
        if ((sb.toString().substring(0,1)).equals("0")){
            return "0";
        }
        else{
            return sb.toString();
        }
    }
}