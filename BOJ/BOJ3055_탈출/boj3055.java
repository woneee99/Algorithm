package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3055 {
	static char[][] map;
	static Queue<int[] > water;
	static int R, C, res;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		water = new ArrayDeque<>();
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int goX = 0, goY = 0, endX = 0, endY = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'S') {
					goX = i; goY = j;
				}
				else if(map[i][j] == 'D') {
					endX = i; endY = j;
				}
				else if(map[i][j] == '*') {
					water.add(new int[] {i, j});
				}
			}
		}
		
		cal(goX, goY, endX, endY);
		if(res == 0) System.out.println("KAKTUS");
		else System.out.println(res);
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void cal(int sX, int sY, int eX, int eY) {
		Queue<int[] > q = new ArrayDeque<>();
		q.add(new int[] {sX, sY, 0});
		
		boolean[][] chk = new boolean[R][C];
		chk[sX][sY] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] pol = q.poll();
			
			if(cnt == pol[2]) {
				int size = water.size();
				for(int i=0; i<size; i++) {
					int[] w = water.poll();
					
					for(int d=0; d<4; d++) {
						int x1 = dx[d] + w[0];
						int y1 = dy[d] + w[1];
						
						if(x1 < 0 || y1 < 0 || x1 >= R || y1 >= C || map[x1][y1] == '*' ||map[x1][y1] == 'D' || map[x1][y1] == 'X') continue;
						map[x1][y1] = '*';
						water.add(new int[] {x1, y1});
					}
				}
				cnt++;
			}
			
			for(int i=0; i<4; i++) {
				int nx = dx[i] + pol[0];
				int ny = dy[i] + pol[1];
				
				if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '*' || chk[nx][ny] || map[nx][ny] == 'X') continue;
				if(map[nx][ny] == 'D') {
					res = pol[2] + 1;
					return;
				}
				
				chk[nx][ny] = true;
				q.add(new int[] {nx, ny, pol[2] + 1});
			}
		}
	}
}
