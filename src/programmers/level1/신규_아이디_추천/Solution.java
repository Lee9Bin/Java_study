package programmers.level1.신규_아이디_추천;

public class Solution {
    public String solution(String new_id) {
        String answer = "";
//      모두 소문자로 바꾸기
        new_id = new_id.toLowerCase();
//      가능 문자가 아닌거 다지우기
        String id = "";
        for (int i = 0 ; i<new_id.length(); i++){
            if(48<=(int)new_id.charAt(i) && (int)new_id.charAt(i)<=57){
                id += new_id.charAt(i) + "";
            }
            if(97<=(int)new_id.charAt(i) && (int)new_id.charAt(i)<=122){
                id += new_id.charAt(i) + "";
            }
            if(new_id.charAt(i) == '-' || new_id.charAt(i)=='_' || new_id.charAt(i)=='.'){
                id += new_id.charAt(i) + "";
            }
        }
        // .이 두번이상 연속되면 .으로 바꾸기
        for (int i = 0; i<10001; i++){
            id = id.replace("..",".");
        }
        //.이 맨처음과 맨 끝이면 제거
        if (id.length() > 2){
            if (id.charAt(0) == '.' && id.charAt(id.length()-1) == '.'){
                id = id.substring(1,id.length()-1);
            }
            else if (id.charAt(0) == '.'){
                id = id.substring(1,id.length());
            }
            else if (id.charAt(id.length()-1) == '.'){
                id = id.substring(0,id.length()-1);
            }
        }
        else if(id.length() == 2){
            if (id.charAt(0) == '.' && id.charAt(id.length()-1) == '.'){
                id = "";
            }
            else if (id.charAt(0) == '.'){
                id = id.substring(1,id.length());
            }
            else if (id.charAt(id.length()-1) == '.'){
                id = id.substring(0,id.length()-1);
            }
        }
        else if(id.length() == 1){
            if(id.charAt(0) == '.'){
                id = "";
            }
        }

        if (id.length() == 0){
            id = "a";
        }

        // 길이가 16이상이면 뒤에거 자르기
        if (id.length() >= 16){
            if (id.charAt(15) == '.'){
                id = id.substring(0,15);
            }
            else{
                id = id.substring(0,15);
                if (id.charAt(14) == '.'){
                    id = id.substring(0,14);
                }
            }
        }
        else if (id.length() <3){
            String news = id.charAt(id.length()-1) + "";
            int cnt = id.length();
            for (int i=0; i< 3-cnt; i++){
                id += news;
            }
        }


        return id;
    }
}