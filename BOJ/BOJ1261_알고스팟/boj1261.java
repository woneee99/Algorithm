import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1261 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j) - '0' == 1 ? false : true;
			}
		}
		
		int min = N*M;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		PriorityQueue<Wall> q = new PriorityQueue<>();
		q.add(new Wall(0, 0, 0));
		boolean[][] chk = new boolean[N][M];
		chk[0][0] = true;
		
		while(!q.isEmpty()) {
			Wall now = q.poll();
			
			if(now.x == N-1 && now.y == M-1) {
				min = Math.min(min, now.cnt);
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nx = dx[i] + now.x;
				int ny = dy[i] + now.y;
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny]) continue;
				chk[nx][ny] = true;
				int cnt = map[nx][ny] == true ? now.cnt : now.cnt + 1;
				q.add(new Wall(nx, ny, cnt));
			}
		}
		
		System.out.println(min);
	}
	
	static class Wall implements Comparable<Wall>{
		int x;
		int y;
		int cnt;
		
		public Wall(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Wall o) {
			return this.cnt - o.cnt;
		}
	}

}
