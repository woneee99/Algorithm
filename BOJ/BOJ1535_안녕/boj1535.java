import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1535 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] him = new int[n+1];
		int[] happy = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			him[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[100];
		for(int i=1; i<=n; i++) {
			for(int j=99; j-him[i]>=0; j--) {
				dp[j] = Math.max(dp[j], dp[j-him[i]] + happy[i]);
			}
		}
		
		System.out.println(dp[99]);
	}

}
