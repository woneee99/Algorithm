import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj17218_1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int[][] dp = new int[str1.length+1][str2.length+1];
		for(int i=1; i<=str1.length; i++) {
			for(int j=1; j<=str2.length; j++) {
				if(str1[i-1] == str2[j-1]) {
					dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i][j-1]);
				}
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		int idx = str2.length;
		StringBuilder sb = new StringBuilder();
		for(int i=str1.length; i>0; i--) {
			for(int j=idx; j>0; j--) {
				if(dp[i][j] == dp[i-1][j]) break;
				if(dp[i][j] == dp[i][j-1]) continue;
				if(dp[i][j] != dp[i-1][j-1]) {
					sb.append(str1[i-1]);
					idx = j-1;
					break;
				}
			}
		}
		System.out.println(sb.reverse().toString());
	}

}
