import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj10422 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[] dp = new long[5001];
		dp[0] = 1;
		dp[2] = 1;
		for(int i=4; i<=5000; i+=2) {
			for(int j=0; j<i; j+=2) {
				dp[i] += (dp[j] * dp[i-j-2]);
				dp[i] %= 1_000_000_007;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
