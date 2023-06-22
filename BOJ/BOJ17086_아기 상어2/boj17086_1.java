import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17086_1 {
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
		
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1) {
					q.add(new int[] {i, j, 0});
				}
			}
		}
		
		int max = 0;
		boolean[][] chk = new boolean[N][M];
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int d=0; d<8; d++) {
				int nx = poll[0] + dx[d];
				int ny = poll[1] + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || arr[nx][ny] == 1) continue;
				chk[nx][ny] = true;
				
				if(arr[nx][ny] == 0) {
//					System.out.println(nx + " " + ny);
					max = Math.max(max, poll[2] + 1);
					q.add(new int[] {nx, ny, poll[2] + 1});
				}
			}
		}
		System.out.println(max);
	}

}
