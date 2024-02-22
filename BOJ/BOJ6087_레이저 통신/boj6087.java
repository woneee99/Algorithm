import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj6087 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[H][W];
		int sx = -1, sy = -1, ex = -1, ey = -1;
		for(int i=0; i<H; i++) {
			String line = br.readLine();
			for(int j=0; j<W; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'C') {
					if(sx == -1) {
						sx = i;
						sy = j;
					}
					else {
						ex = i;
						ey = j;
					}
				}
			}
		}
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		PriorityQueue<Mirror> q = new PriorityQueue<>();
		q.add(new Mirror(sx, sy, 0, -5));
		
		int[][][] chk = new int[H][W][4];
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				Arrays.fill(chk[i][j], H*W);
			}
		}
		int res = H*W;
		while(!q.isEmpty()) {
			Mirror mirror = q.poll();
			
			if(mirror.x == ex && mirror.y == ey) {
				res = Math.min(res, mirror.cnt);
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int nx = mirror.x + dx[i];
				int ny = mirror.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == '*') continue;
				if(Math.abs(mirror.dir - i) == 2) continue;
				int cnt = (mirror.dir == i || mirror.dir == -5) ? mirror.cnt : mirror.cnt + 1;

				if(chk[nx][ny][i] > cnt) {
					chk[nx][ny][i] = cnt;
					q.add(new Mirror(nx, ny, cnt, i));
				}
			}
		}
		
		System.out.println(res);
	}
	static class Mirror implements Comparable<Mirror>{
		int x; 
		int y;
		int cnt;
		int dir;
		
		public Mirror(int x, int y, int cnt, int dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(Mirror o) {
			return this.cnt - o.cnt;
		}
	}
}
