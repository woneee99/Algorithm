import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11051 {
	static int[][] dp;
	static final int num = 10_007;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		dp = new int[N+1][K+1];
		System.out.println(comb(N, K));
	}
	
	static int comb(int n, int r) {
		if(dp[n][r] > 0) return dp[n][r];
		if(r == 0 || n == r) return dp[n][r] = 1;
		return dp[n][r] = (comb(n-1, r) + comb(n-1, r-1)) % num;
	}
}
