import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1300 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long start = 1, end = K;
        while(start < end) {

            long mid = (start + end) / 2;
            long cnt = 0;

            for(int i=1; i<=N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if(K <= cnt) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
