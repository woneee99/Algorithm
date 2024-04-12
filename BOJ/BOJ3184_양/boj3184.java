import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3184 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		ArrayList<int[] > wolf = new ArrayList<>();
		int sRes = 0;
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'v') wolf.add(new int[] {i, j});
				else if(map[i][j] == 'o') sRes++;
			}
		}
		
		int wRes = wolf.size();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		boolean[][] chk = new boolean[R][C];
		for(int[] w : wolf) {
			if(chk[w[0]][w[1]]) continue;
			
			Queue<int[] > q = new LinkedList<>();
			q.add(w);
			chk[w[0]][w[1]] = true;
			int wCnt = 1, sCnt = 0;
			while(!q.isEmpty()) {
				int[] now = q.poll();
				
				for(int i=0; i<4; i++) {
					int nx = now[0] + dx[i];
					int ny = now[1] + dy[i];
					
					if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
					if(map[nx][ny] == '#' || chk[nx][ny]) continue;
					
					if(map[nx][ny] == 'v') wCnt++;
					else if(map[nx][ny] == 'o') sCnt++;
					
					q.add(new int[] {nx, ny});
					chk[nx][ny] = true;
				}
			}
			
			if(wCnt >= sCnt) sRes -= sCnt;
			else wRes -= wCnt;
		}
		
		System.out.println(sRes + " " + wRes);
	}

}
