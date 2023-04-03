package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_4193_수영대회결승전 {
	static int[][] map;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			StringTokenizer st;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			sb.append("#").append(t).append(" ").append(cal(startX, startY, endX, endY)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cal(int startX, int startY, int endX, int endY) {
		Queue<int[] > q= new ArrayDeque<int[]>();
		q.add(new int[] {startX, startY, 0});
		
		boolean[][] chk = new boolean[N][N];
		chk[startX][startY] = true;
		while(!q.isEmpty()) {
			int[] pol = q.poll();
			
			int nx = pol[0], ny = pol[1], count = pol[2];
			if(map[nx][ny] == 2 && count % 3 != 0) {
				q.add(new int[] {nx, ny, count+1});
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int x = pol[0] + dx[i];
				int y = pol[1] + dy[i];
				
				if(x < 0 || y < 0 || x>= N || y >= N || chk[x][y] || map[x][y] == 1) continue;
				chk[x][y] = true;
				
				if(x == endX && y == endY) {
					return count + 1;
				}
				q.add(new int[] {x, y, count+1});
			}
		}
		
		return -1;
	}
}
