import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9084 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int result = Integer.parseInt(br.readLine());
			int[] coin = new int[N];
			int[] dp = new int[result+1];
			
			for(int j=0; j<N; j++) {
				coin[j] = Integer.parseInt(st.nextToken());
			}
			
			dp[0] = 1;
			
			for(int j : coin) {
				for(int k=j; k<=result; k++) {
					dp[k] += dp[k-j];
				}
			}
			sb.append(dp[result]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
