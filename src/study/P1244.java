package study;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1244 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] light = new int[n+1];
        int index = 1;
        while(st.hasMoreTokens()) {
            light[index++] = Integer.parseInt(st.nextToken());
        }

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i< cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int zender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(zender == 1) {
                for (int j = num; j < n+1; j+=num) {
                    change(j, light);
                }
            }
            else {
                change(num, light);
                int a = 1;
                while(true) {
                    if (num - a < 1 || num + a >=n+1) {
                        break;
                    }
                    if (light[num-a] == light[num+a]) {
                        change(num-a, light);
                        change(num+a, light);
                    }
                    else {
                        break;
                    }
                    a ++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            if(i == n) {
                sb.append(light[i]);
            }
            else if (i % 20 == 0) {
                sb.append(light[i]).append("\n");
            }
            else {
                sb.append(light[i]).append(" ");
            }
        }
        System.out.println(sb);
    }
    private static void change(int index, int[] light) {
        if (light[index] == 1) {
            light[index] = 0;
        }
        else {
            light[index] = 1;
        }
    }
}
