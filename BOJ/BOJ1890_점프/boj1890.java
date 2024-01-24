import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1890 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        long[][] dp = new long[N][N];
        dp[0][0] = 1;
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		int num = map[i][j];
        		
        		if(i == N-1 && j == N-1) break;
        		
        		if(i+num < N) dp[i+num][j] += dp[i][j];
        		if(j+num < N) dp[i][j+num] += dp[i][j];
        	}
        }
        
        System.out.println(dp[N-1][N-1]);
	}

}
