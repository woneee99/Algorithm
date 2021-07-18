import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053_topdown {
	static int []arr;
	static Integer []dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[num];
		dp = new Integer[num];
		
		for(int i=0; i<num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<num; i++) {
			DP(i);
		}
		
		int max = dp[0];
		for(int i=1; i<num; i++) {
			max = max < dp[i] ? dp[i]: max;
		}
		System.out.println(max);
	}
	
	static int DP(int x) {
		if(dp[x] == null) {
			dp[x] = 1;
			for(int i=x-1; i>=0; i--) {
				if(arr[i] < arr[x]) {
					dp[x] = Math.max(dp[x], DP(i)+1);
				}
			}
		}
		return dp[x];
	}
}
