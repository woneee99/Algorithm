import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1937 {
	static int[][] forest, dp;
	static int max, n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		forest = new int[n][n];		
		dp = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				res = Math.max(dfs(i, j), res);
			}
		}
		
		System.out.println(res);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int dfs(int nx, int ny) {
		if(dp[nx][ny] != 0) return dp[nx][ny];
		
		dp[nx][ny] = 1;
		for(int i=0; i<4; i++) {
			int x = dx[i] + nx;
			int y = dy[i] + ny;
			
			if(x < 0 || y < 0 || x >= n || y >= n) continue;
			if(forest[x][y] > forest[nx][ny]) {
				dp[nx][ny] = Math.max(dp[nx][ny], dfs(x, y) + 1);
			}
		}
		
		return dp[nx][ny];
	}
}
