import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1932 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp[1][1] = Integer.parseInt(st.nextToken());
		
		for(int i=2; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=i; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] += dp[i-1][j-1] > dp[i-1][j] ? dp[i-1][j-1] : dp[i-1][j];
			}
		}
		
		Arrays.sort(dp[N]);
		System.out.println(dp[N][N]);
	}

}
