package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P1544 {

    static HashMap<String, Set<String>> check;

    public static void main(String[] args) throws IOException {
        check = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            //단어 하나를 입력
            String word = br.readLine();
            boolean flag = true;
            for (String s : check.keySet()) {
                for (String ss : check.get(s)){
                    if (ss.equals(word)) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                check.put(word, make(word));
            }

        }
        System.out.println(check.size());
    }
    public static Set<String> make(String word) {
        Set<String> set = new HashSet<>();
        for (int start = 0; start < word.length(); start++) {
            StringBuilder sb = new StringBuilder();
            for (int cnt = 0; cnt < word.length(); cnt++) {
                sb.append(word.charAt((start + cnt) % word.length()));
            }
            String newWord = sb.toString();
            set.add(newWord);
        }
        return set;
    }
}
