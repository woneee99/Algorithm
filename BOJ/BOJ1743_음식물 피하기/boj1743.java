import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1743 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[][] food = new boolean[N+1][M+1];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			food[r][c] = true;
		}
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		boolean[][] chk = new boolean[N+1][M+1];
		int max = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(!food[i][j] || chk[i][j]) continue;
				chk[i][j] = true;
				
				Queue<int[] > q = new LinkedList<int[]>();
				q.add(new int[] {i, j});
				int cnt = 1;
				while(!q.isEmpty()) {
					int[] poll = q.poll();
					
					for(int d=0; d<4; d++) {
						int nx = poll[0] + dx[d];
						int ny = poll[1] + dy[d];
						
						if(nx <= 0 || ny <= 0 || nx > N || ny > M || chk[nx][ny] || !food[nx][ny]) continue;
						q.add(new int[] {nx, ny});
						chk[nx][ny] = true;
						cnt++;
					}
				}
				max = Math.max(max, cnt);
			}
		}
		System.out.println(max);
	}

}
