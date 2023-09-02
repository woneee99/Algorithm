import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2482 {
	private static final int MOD = 1_000_000_003;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			dp[i][1] = i;
		}
		
		for(int i=4; i<=N; i++) {
			for(int j=2; j<=K; j++) { // i번째 색 선택 X + i번째 색 선택 O
				dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % MOD;
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
