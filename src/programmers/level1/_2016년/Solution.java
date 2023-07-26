package programmers.level1._2016년;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] ndays = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int smonth = 1;
        int sday = 1;
        int nowcnt = 5;
        while(smonth != a || sday != b){
            if (smonth < 8){
                if (smonth % 2 != 0){
                    sday += 1;
                    nowcnt += 1;
                    if (sday == 32){
                        smonth +=1;
                        sday = 1;
                    }
                }
                else if (smonth % 2 == 0){
                    if (smonth == 2){
                        sday +=1;
                        nowcnt +=1;
                        if (sday == 30){
                            smonth +=1;
                            sday = 1;

                        }
                    }
                    else{
                        sday +=1;
                        nowcnt +=1;
                        if (sday == 31){
                            smonth +=1;
                            sday = 1;
                        }
                    }
                }
            }
            else{
                if (smonth % 2 != 0){
                    sday += 1;
                    nowcnt += 1;
                    if (sday == 31){
                        smonth +=1;
                        sday = 1;
                    }
                }
                else if (smonth % 2 == 0){
                    if (smonth == 2){
                        sday +=1;
                        nowcnt +=1;
                        if (sday == 30){
                            smonth +=1;
                            sday = 1;

                        }
                    }
                    else{
                        sday +=1;
                        nowcnt +=1;
                        if (sday == 32){
                            smonth +=1;
                            sday = 1;
                        }
                    }
                }
            }
            System.out.println(nowcnt);}
            answer = ndays[nowcnt%7];
            return answer;
        }
}