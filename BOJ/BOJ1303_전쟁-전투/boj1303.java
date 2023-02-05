import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1303 {
	static boolean[][] chk;
	static char[][] arr;
	static int n, m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		chk = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		int blue = 0, white = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!chk[i][j]) {
					chk[i][j] = true;
					int cnt = cal(i, j);
					if(arr[i][j] == 'W') white += cnt;
					else blue += cnt;
				}
			}
		}
		System.out.println(white + " " + blue);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cal(int i, int j) {
		Queue<int[] > q = new LinkedList<>();
		q.add(new int[] {i, j});
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] pol = q.poll();
			
			for(int k=0; k<4; k++) {
				int x = dx[k] + pol[0];
				int y = dy[k] + pol[1];
				
				if(x < 0 || y < 0 || x >= n || y >= m) continue;
				if(chk[x][y] || arr[i][j] != arr[x][y]) continue;
				
				chk[x][y] = true;
				q.add(new int[] {x, y});
				cnt++;
			}
			
		}
		return cnt*cnt;
	}
}
