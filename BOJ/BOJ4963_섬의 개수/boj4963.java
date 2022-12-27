import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj4963 {
	static boolean[][] chk;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			chk = new boolean[w][h];
			arr = new int[w][h];
			
			for(int i=0; i<w; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<h; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int i=0; i<w; i++) {
				for(int j=0; j<h; j++) {
					if(!chk[i][j] && arr[i][j] == 1) {
						chk[i][j] = true;
						cal(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};
	
	static void cal(int nx, int ny) {
		for(int i=0; i<8; i++) {
			int x = dx[i] + nx;
			int y = dy[i] + ny;
			
			if(x >= 0 && y >= 0 && x < arr.length && y < arr[0].length) {
				if(!chk[x][y] && arr[x][y] == 1) {
					chk[x][y] = true;
					cal(x, y);
				}
			}
		}
	}
}
