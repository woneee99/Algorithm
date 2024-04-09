import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj14916 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		if(n >= 2) dp[2] = 1;
		if(n >= 4) dp[4] = 2;
		if(n >= 5) dp[5] = 1;
		
		for(int i=6; i<=n; i++) {
			if(dp[i-2] == 0 && dp[i-5] == 0) continue;
			if(dp[i-2] == 0) dp[i] = dp[i-5] + 1;
			else if(dp[i-5] == 0) dp[i] = dp[i-2] + 1;
			else dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
		}
		System.out.println(dp[n] == 0 ? -1 : dp[n]);
	}

}
