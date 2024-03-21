import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15988 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[1_000_001];
		int max = 4;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			for(int j=max; j<=n; j++) {
				dp[j] = dp[j-1] % 1_000_000_009 + dp[j-2] % 1_000_000_009 + dp[j-3] % 1_000_000_009;
			}
			max = Math.max(max, n);
			sb.append(dp[n] % 1_000_000_009).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
