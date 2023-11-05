import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17142 {
	static int N, M, cnt;
	static ArrayList<int[] > virus;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		virus = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) cnt++;
				else if(arr[i][j] == 2) virus.add(new int[] {i, j});
			}
		}
		
		array = new int[M];
		dfs(0, 0);
		System.out.println(MIN == 2501 ? -1 : MIN);
	}

	static int MIN = 2501;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] array;
	static boolean[][] chk;
	static void dfs(int depth, int idx) {
		if(depth == M) {
			Queue<int[] > q = new LinkedList<>();
			chk = new boolean[N][N];
			
			for(int i=0; i<M; i++) {
				int index = array[i];
				int[] v = virus.get(index);
				q.add(v);
				chk[v[0]][v[1]] = true;
			}
			
			int time = 0, count = M;
			while(!q.isEmpty()) {
				int sz = q.size();
				time++;
				
				if(cnt <= count) {
					if(check()) {
						MIN = Math.min(MIN, time - 1);
						break;
					}
				}
				
				for(int s=0; s<sz; s++) {
					int[] v = q.poll();
					
					for(int i=0; i<4; i++) {
						int nx = v[0] + dx[i];
						int ny = v[1] + dy[i];
						
						if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 1 || chk[nx][ny]) continue;
						chk[nx][ny] = true;
						count++;
						q.add(new int[] {nx, ny});
					}
				}
			}
			return;
		}
		
		for(int i=idx; i<virus.size(); i++) {
			array[depth] = i;
			dfs(depth + 1, i+1);
		}
	}
	
	static boolean check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 0 && !chk[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
