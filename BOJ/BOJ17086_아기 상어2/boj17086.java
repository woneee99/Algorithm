import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17086 {
	static int N, M;
	static int[][] arr;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
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
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1) continue;
				cal(i, j);
			}
		}
		System.out.println(max);
	}
	static int max = 0;
	static void cal(int x, int y) {
		boolean[][] chk = new boolean[N][M];
		chk[x][y] = true;
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x, y, 0});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			for(int d=0; d<8; d++) {
				int nx = poll[0] + dx[d];
				int ny = poll[1] + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny]) continue;
				chk[nx][ny] = true;
				if(arr[nx][ny] == 0) q.add(new int[] {nx, ny, poll[2] + 1});
				else {
					System.out.println(nx + " " + ny);
					max = Math.max(max, poll[2] + 1);
					return;
				}
			}
		}
	}
}
