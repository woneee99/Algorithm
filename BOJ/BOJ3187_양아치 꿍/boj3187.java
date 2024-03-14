import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3187 {
	static int R, C, sCnt, wCnt;
	static char[][] map;
	static boolean[][] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		chk = new boolean[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(chk[i][j] || map[i][j] == '.' || map[i][j] == '#') continue;
				chk[i][j] = true;
				
				bfs(i, j);
			}
		}
		
		bw.write(sCnt + " " + wCnt);
		bw.flush();
		bw.close();
	}
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void bfs(int x, int y) {
		int s = 0, w = 0;
		if(map[x][y] == 'v') w++;
		else s++;
		
		Queue<int[] > q = new LinkedList<int[]>();
		q.add(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int d=0; d<4; d++) {
				int nx = poll[0] + dx[d];
				int ny = poll[1] + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
				if(chk[nx][ny] || map[nx][ny] == '#') continue;
				if(map[nx][ny] == 'v') w++;
				else if(map[nx][ny] == 'k') s++;
				
				chk[nx][ny] = true;
				q.add(new int[] {nx, ny});
			}
		}
		if(s <= w) wCnt += w;
		else sCnt += s;
	}
}	
