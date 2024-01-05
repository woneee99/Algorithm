import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1189 {
	static boolean[][] chk;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] map;
	static int R, C, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		chk = new boolean[R][C];
		chk[R-1][0] = true;
		
		dfs(1, R-1, 0);
		System.out.println(res);
	}
	static int res;
	static void dfs(int depth, int x, int y) {
		if(depth > K) return;
		if(depth == K) {
			 res++;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
			if(chk[nx][ny] || map[nx][ny] == 'T') continue;
			
			chk[nx][ny] = true;
			dfs(depth + 1, nx, ny);
			chk[nx][ny] = false;
		}
	}
}
