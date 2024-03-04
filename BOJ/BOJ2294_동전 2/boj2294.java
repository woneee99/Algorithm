import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2294 {
	static final int INF = 10_000_000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[K+1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for(int i=0; i<N; i++) {
			int cnt = coin[i];
			for(int j=cnt; j<=K; j++) {
				dp[j] = Math.min(dp[j], dp[j - cnt] + 1);
			}
		}
		System.out.println(dp[K] == INF ? -1 : dp[K]);
	}

}
