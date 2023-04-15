import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2573 {
	static int[][] arr;
	static boolean[][] chk;
	static ArrayList<int[] > san = new ArrayList<>(); 
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 0) san.add(new int[] {i, j});
			}
		}
		
		int res = 0;
		int[][] map = new int[N][M];
		while(true) {
			for(int i=0; i<N; i++) {
				map[i] = arr[i].clone();
			}
			
			// 빙산 녹임
			for(int i=0; i<san.size(); i++) {
				int[] one = san.get(i);
				
				int count = 0;
				for(int j=0; j<4; j++) {
					int nx = one[0] + dx[j];
					int ny = one[1] + dy[j];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					if(arr[nx][ny] == 0) count++;
				}
				map[one[0]][one[1]] -= count;
				if(map[one[0]][one[1]] <= 0 ) {
					map[one[0]][one[1]] = 0;
					san.remove(i);
					i--;
				}
			}
			
			for(int i=0; i<N; i++) {
				arr[i] = map[i].clone();
			}
			res++;
			
			chk = new boolean[N][M];

			// 빙산 개수 확인
			int cnt = 0;
			for(int i=0; i<san.size(); i++) {
				int[] get = san.get(i);
				if(chk[get[0]][get[1]]) continue;
				chk[get[0]][get[1]] = true;
				cntCheck(get[0], get[1], map);
				cnt++;
			}
			
			if(cnt >= 2) break;
			
			if(san.size() == 0) {
				res = 0;
				break;
			}
		}
		System.out.println(res);
	}
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void cntCheck(int x, int y, int[][] map) {
		Queue<int[] > q = new ArrayDeque<>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] pol = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = pol[0] + dx[i];
				int ny = pol[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0 || chk[nx][ny]) continue;
				chk[nx][ny] = true;
				q.add(new int[] {nx, ny});
			}
		}
	}
}
