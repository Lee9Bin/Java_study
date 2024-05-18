package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class target{
    String s;
    int count;

    public target(String s, int count){
        this.s = s;
        this.count = count;
    }
}

public class P25325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> students = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            students.put(st.nextToken(), 0);
        }

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                String likeStudent = st.nextToken();
                if (students.containsKey(likeStudent)){
                    students.put(likeStudent, students.get(likeStudent) + 1);
                }
                else {
                    students.put(likeStudent, 0);
                }
            }
        }

        target[] result = new target[n];

        int index = 0;
        for (String s : students.keySet()) {
            result[index++] = new target(s, students.get(s));
        }

        Arrays.sort(result, (target o1, target o2) -> {
            return o1.count != o2.count ? o2.count - o1.count : o1.s.compareTo(o2.s);
        });
        StringBuilder sb = new StringBuilder();
        for (target target : result) {
            sb.append(target.s).append(" ").append(target.count).append("\n");
        }
        System.out.println(sb);
    }
}
