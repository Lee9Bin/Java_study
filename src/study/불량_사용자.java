package study;

import java.util.*;

public class 불량_사용자 {

    static ArrayList<ArrayList<String>> matchList;
    static HashMap<String, Boolean> visited;
    static HashMap<String, Boolean> isMake;
    static int result = 0;

    // public static void main(String[] args) {
    //     불량_사용자 s = new 불량_사용자();
    //     s.solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"fr*d*", "abc1**"});
    // }

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        //banned_id에 각 원소에 해당하는 것들 따로 뽑아내기

        matchList = new ArrayList<>();

        for (int i = 0; i < banned_id.length; i++){
            matchList.add(new ArrayList<>());
        }

        for (String id : user_id) {
            //길이가 같을것
            //*부분 제외하고 나머지 글자 같을것
            for(int i = 0; i < matchList.size(); i++){
                if (id.length() == banned_id[i].length()){
                    boolean flag = true;
                    for (int j = 0; j < id.length(); j++){
                        if (banned_id[i].charAt(j) == '*') continue;
                        if (id.charAt(j) != banned_id[i].charAt(j)){
                            flag = false;
                            break;
                        }
                    }
                    if (flag) matchList.get(i).add(id);
                }
            }
        }
        //완성
        visited = new HashMap<>();
        // for (ArrayList<String> strings : matchList) {
        //     System.out.println(strings);
        // }
        ArrayList<String> list = new ArrayList<>();
        isMake = new HashMap<>();
        dfs(0, list);
        answer = result;
        return answer;
    }

    public static void dfs(int index, ArrayList<String> list){
        if (index == matchList.size()){
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) sb.append(list.get(i));
            if (!isMake.containsKey(sb.toString())){
                result ++;
                isMake.put(sb.toString(), true);
            }
            return;
        }

        for (int i = 0; i < matchList.get(index).size(); i++){
            if (!visited.containsKey(matchList.get(index).get(i)) || !visited.get(matchList.get(index).get(i))){
                visited.put(matchList.get(index).get(i), true);
                list.add(matchList.get(index).get(i));
                System.out.println(matchList.get(index).get(i));
                dfs( index+1, list);
                list.remove(matchList.get(index).get(i));
                visited.put(matchList.get(index).get(i), false);
            }
        }
    }
}
