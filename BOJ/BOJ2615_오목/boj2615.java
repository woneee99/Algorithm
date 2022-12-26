import java.io.*;
import java.util.*;

public class boj2615 {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[19][19];
		for(int i=0; i<19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(arr[i][j] != 0) {
					cal(i, j);
				}
			}
		}
		System.out.println(0);
	}

	static int[] dx = {1, -1, 0, 1};
	static int[] dy = {1, 1, 1, 0};
	static int[] chkX = {-1, 1, 0, -1};
	static int[] chkY = {-1, -1, -1, 0};
	
	static void cal(int x, int y) {
		int originX = x, originY = y;
		for(int i=0; i<4; i++) {
			int cnt = 1;
			x = originX; y = originY;
			if(x + chkX[i] >= 0 && x + chkX[i] < 19 && y + chkY[i] >= 0 && y + chkY[i] < 19) {
				if(arr[x+chkX[i]][y+chkY[i]] == arr[x][y]) continue;
			}
			while(cnt < 6) { 
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if(nx >= 0 && ny >= 0 && nx < 19 && ny < 19 && (arr[x][y] == arr[nx][ny])) {					
					cnt++;
					x = nx; y = ny;
				}
				else break;
			}
			if(cnt == 5) {
				System.out.println(arr[x][y]);
				System.out.println((originX+1) + " " + (originY+1));
				System.exit(0);
			}
		}
		
	}
}
