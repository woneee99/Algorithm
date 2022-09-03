import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[5001];
		dp[3] = 1;
		dp[5] = 1;
		
		for(int i=6; i<=n; i++) {
			if(dp[i-5] != 0) {
				dp[i] = dp[i-5] + 1;
			}
			else if(dp[i-3] != 0) {
				dp[i] = dp[i-3] + 1;
			}
		}
		if(dp[n] == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[n]);
		}
	}

}
