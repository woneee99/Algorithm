import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj9252 {
	static int[][] dp;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();

		dp = new int[A.length()+1][B.length()+1];
		sb = new StringBuilder();
		
		for(int i=1; i <= A.length(); i++) {
			for(int j=1; j<= B.length(); j++) {
				if(A.charAt(i-1) == B.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

		System.out.println(dp[A.length()][B.length()]);
		if(dp[A.length()][B.length()] == 0) {
			System.exit(0);
		}
		
		cal(A, A.length(), B.length());
		
		System.out.println(sb.reverse().toString());
	}
	static void cal(String A, int x, int y) {
		if(x <= 0 || y <= 0) return;
		if(dp[x][y] == dp[x-1][y]) {
			x--;
		}
		else if(dp[x][y] == dp[x][y-1]) {
			y--;
		}
		else {
			sb.append(A.charAt(x-1));
			x--;
			y--;
		}
		cal(A, x, y);
	}
}

