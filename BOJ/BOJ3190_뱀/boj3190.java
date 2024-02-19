import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj3190 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		int[][] map = new int[N+1][N+1];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			map[row][col] = 1;
		}
		
		int cnt = 1, dir = 1;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int L = Integer.parseInt(br.readLine());
		
		Deque<int[] > dq = new ArrayDeque<>();
		dq.add(new int[] {1, 1});
		int nx = 1, ny = 1;
		map[nx][ny] = 2;
		boolean chk = false;
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			
			if(chk) continue;
			while(cnt <= X) {

				nx += dx[dir];
				ny += dy[dir];
				dq.add(new int[] {nx, ny});
				
				if(nx < 1 || ny < 1 || nx > N || ny > N || map[nx][ny] == 2) {
					chk = true;
					break;
				}
				
				if(map[nx][ny] == 1) map[nx][ny] = 2;
				else {
					map[nx][ny] = 2;
					int[] p = dq.poll();
					map[p[0]][p[1]] = 0;
				}
				cnt++;
			}
			if(chk) continue;
			if(C == 'L') {
				if(dir == 0) dir = 3;
				else dir--;
			}
			else if(C == 'D') dir = (dir + 1) % 4;
		}
		while(!chk) {
			
			nx += dx[dir];
			ny += dy[dir];
			dq.add(new int[] {nx, ny});
			
			if(nx < 1 || ny < 1 || nx > N || ny > N || map[nx][ny] == 2) {
				chk = true;
				break;
			}
			
			if(map[nx][ny] == 1) map[nx][ny] = 2;
			else {
				map[nx][ny] = 2;
				int[] p = dq.poll();
				map[p[0]][p[1]] = 0;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}