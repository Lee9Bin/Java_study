import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2-o1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            if (now == 0){
                if(heap.isEmpty()) sb.append(-1).append("\n");
                else sb.append(heap.poll()).append("\n");
            }
            else {
                for (int j = 0; j < now; j++){
                    heap.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.println(sb);
    }
}
