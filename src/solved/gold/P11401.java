import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11401 {
	static long N, R;
    static final long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        long A = getFactorial(N);
        long B = fastPow(getFactorial(N - R), mod - 2) % mod;
        long C = fastPow(getFactorial(R), mod - 2) % mod;

        System.out.println(((A * B % mod) * C) % mod);
    }


    public static long getFactorial(long n) {
        long result = 1;

        for (long i = n; i >= 1; i--) {
            result = (result * i) % mod;
        }
        return result;
    }

    public static long fastPow(long n, long cnt) {
        if (cnt == 0) {
            return 1;
        }
        long temp = fastPow(n, cnt / 2);
        if (cnt % 2 == 0) {
            return temp * temp % mod;
        } else {
            return (temp * temp % mod) * n % mod;
        }
    }
}
