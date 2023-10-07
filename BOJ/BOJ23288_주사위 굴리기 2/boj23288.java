import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj23288 {
	static int[][] map;
	static int[] dice;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dice = new int[]{1, 6, 4, 3, 2, 5}; // »ó ÇÏ ÁÂ ¿ì ¾Õ µÚ
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int dir = 0;
		int nx = 0; int ny = 0;
		int score = 0;
		for(int i=0; i<K; i++) {
			nx += dx[dir];
			ny += dy[dir];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
				nx -= dx[dir];
				ny -= dy[dir];
				dir = (dir + 2) % 4;
				nx += dx[dir];
				ny += dy[dir];
			}
			
			changeDice(dir);
			int res = move(nx, ny);
			int A = dice[1];
			int B = map[nx][ny];
			score += (res * B);
			
			if(A > B) dir = (dir + 1) % 4;
			else if(A < B) {
				if(dir == 0) dir = 3;
				else dir -= 1;
			}

		}
		System.out.println(score);
	}
	
	static void changeDice(int type) {
		int one = dice[0];
		int two = dice[1];
		int three = dice[2];
		int four = dice[3];
		int five = dice[4];
		int six = dice[5];
		
		if(type == 0) { // µ¿
			dice[0] = three;
			dice[1] = four;
			dice[2] = two;
			dice[3] = one;
		}
		else if(type == 1) { // ³²
			dice[0] = five;
			dice[1] = six;
			dice[4] = two;
			dice[5] = one;
		}
		else if(type == 2) { // ¼­
			dice[0] = four;
			dice[1] = three;
			dice[2] = one;
			dice[3] = two;
		}
		else { // ºÏ
			dice[0] = six;
			dice[1] = five;
			dice[4] = one;
			dice[5] = two;
		}
	}

	static int move(int x, int y) {
		int cnt = 1;
		int score = map[x][y];
		
		boolean[][] chk = new boolean[N][M];
		Queue<int[] > q = new LinkedList<int[]>();
		chk[x][y] = true;
		q.add(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			x = poll[0];
			y = poll[1];
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || map[nx][ny] != score) continue;
				chk[nx][ny] = true;
				cnt++;
				q.add(new int[] {nx, ny});
			}
		}
		return cnt;
	}
}
