import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj12852 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		int[] route = new int[N+1];
		
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			route[i] = i-1;
			
			if(i % 3 == 0 && dp[i/3] + 1 < dp[i]) {
				dp[i] = dp[i / 3] + 1;
				route[i] = i / 3;
			}
			if(i % 2 == 0 && dp[i/2] + 1 < dp[i]) {
				dp[i] = dp[i / 2] + 1;
				route[i] = i / 2;
			}
		}
		
		System.out.println(dp[N]);
		StringBuilder sb = new StringBuilder();
		sb.append(N).append(" ");
		while(N > 1) {
			sb.append(route[N]).append(" ");
			N = route[N];
		}
		System.out.println(sb);
	}

}
