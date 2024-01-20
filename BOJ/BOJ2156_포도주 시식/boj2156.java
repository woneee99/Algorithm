import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2156 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] podo = new int[N+1];
		for(int i=1; i<=N; i++) {
			podo[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N+1];
		dp[1] = podo[1];
		if(N > 1) dp[2] = podo[1] + podo[2];
		for(int i=3; i<=N; i++) {
			dp[i] = podo[i];
			dp[i] += Math.max(podo[i-1]+dp[i-3], dp[i-2]);
			dp[i] = Math.max(dp[i-1], dp[i]);
		}
		
		System.out.println(dp[N]);
	}

}
