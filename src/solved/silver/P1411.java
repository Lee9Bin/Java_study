package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class P1411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words.add(word);
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                HashMap<Character, Character> firstToSecond = new HashMap<>();
                HashMap<Character, Character> secondToFirst = new HashMap<>();
                boolean flag = true;

                for (int k = 0; k < words.get(i).length(); k++) {
                    char first = words.get(i).charAt(k);
                    char second = words.get(j).charAt(k);

                    if (firstToSecond.containsKey(first)) {
                        if (firstToSecond.get(first) != second) {
                            flag = false;
                            break;
                        }
                    } else {
                        firstToSecond.put(first, second);
                    }

                    // B -> A 매핑 검사
                    if (secondToFirst.containsKey(second)) {
                        if (secondToFirst.get(second) != first) {
                            flag = false;
                            break;
                        }
                    } else {
                        secondToFirst.put(second, first);
                    }
                }

                if (flag) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
