package solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P11507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cardsInfo = br.readLine();

        HashMap<Character, int[]> cards = new HashMap<>();
        cards.put('P', new int[14]);
        cards.put('K', new int[14]);
        cards.put('H', new int[14]);
        cards.put('T', new int[14]);


        for (int i = 0; i < cardsInfo.length(); i += 3) {
            char kinds = cardsInfo.charAt(i);
            int num = Integer.parseInt(cardsInfo.substring(i + 1, i + 3));
            int[] card = cards.get(kinds);

            if (card[num] == 1) {
                System.out.println("GRESKA");
                return;
            } else {
                card[0] += 1;
                card[num] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(13 - cards.get('P')[0]).append(" ");
        sb.append(13 - cards.get('K')[0]).append(" ");
        sb.append(13 - cards.get('H')[0]).append(" ");
        sb.append(13 - cards.get('T')[0]).append(" ");
        System.out.println(sb);
    }
}
