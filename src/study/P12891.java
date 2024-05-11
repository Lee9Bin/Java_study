package study;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P12891 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String DNA = br.readLine();

        Map<String, Integer> DNAList = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        DNAList.put("A", Integer.parseInt(st.nextToken()));
        DNAList.put("C", Integer.parseInt(st.nextToken()));
        DNAList.put("G", Integer.parseInt(st.nextToken()));
        DNAList.put("T", Integer.parseInt(st.nextToken()));

        //입력 받기 끝
        int[] DNACount = new int[4];
        int result = 0;

        for (int i = 0; i<s ; i++) {
            if (i < p) {
                if (DNA.charAt(i) == 'A') {
                    DNACount[0] += 1;
                }
                else if (DNA.charAt(i) == 'C') {
                    DNACount[1] += 1;
                }
                else if (DNA.charAt(i) == 'G') {
                    DNACount[2] += 1;
                }
                else if (DNA.charAt(i) == 'T') {
                    DNACount[3] += 1;
                }
            }
            else {
                if (DNA.charAt(i) == 'A') {
                    DNACount[0] += 1;
                }
                else if (DNA.charAt(i) == 'C') {
                    DNACount[1] += 1;
                }
                else if (DNA.charAt(i) == 'G') {
                    DNACount[2] += 1;
                }
                else if (DNA.charAt(i) == 'T') {
                    DNACount[3] += 1;
                }

                if (DNA.charAt(i-p) == 'A') {
                    DNACount[0] -= 1;
                }
                else if (DNA.charAt(i-p) == 'C') {
                    DNACount[1] -= 1;
                }
                else if (DNA.charAt(i-p) == 'G') {
                    DNACount[2] -= 1;
                }
                else if (DNA.charAt(i-p) == 'T') {
                    DNACount[3] -= 1;
                }
            }

            if (DNACount[0] >= DNAList.get("A")
                    && DNACount[1] >= DNAList.get("C")
                    && DNACount[2] >= DNAList.get("G")
                    && DNACount[3] >= DNAList.get("T")&&i>=p-1) {
                result += 1;
            }

        }
        System.out.println(result);

    }
}
