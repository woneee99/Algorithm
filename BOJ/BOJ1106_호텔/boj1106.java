import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1106 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[1101];
		Arrays.fill(dp, 100001);
		int[] c = new int[N];
		int[] p = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int per = Integer.parseInt(st.nextToken());
			dp[per] = Math.min(cost, dp[per]);
			c[i] = cost;
			p[i] = per;
		}
		
		for(int i=1; i<dp.length; i++) {
			for(int j=0; j<c.length; j++) {
				if(i - p[j] < 0) continue;
				dp[i] = Math.min(dp[i], dp[i-p[j]] + c[j]);
			}
		}
		
		int res = 100001;
		for(int i=C; i<dp.length; i++) {
			res = Math.min(dp[i], res);
		}
		System.out.println(res);
	}

}
