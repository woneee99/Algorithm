import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9466 {
	static int[] team;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			team = new int[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				team[j] = Integer.parseInt(st.nextToken());
			}
			
			chk = new boolean[n+1];
			done = new boolean[n+1];
			cnt = 0;
			for(int j=1; j<=n; j++) {
				if(done[j]) continue;
				dfs(j);
			}
			sb.append(n - cnt).append("\n");
		}
		System.out.println(sb);
	}
	static boolean[] chk, done;
	static int cnt;
	static void dfs(int idx) {
		if(done[idx]) return;
		if(chk[idx]) {
			done[idx] = true;
			cnt++;
		}
		else chk[idx] = true;
		
		dfs(team[idx]);
		done[idx] = true;
		chk[idx] = false;
	}
}