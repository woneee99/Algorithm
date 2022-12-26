import java.io.*;
import java.util.*;

public class boj14503 {
	static int n, m;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cal(r, c, d);
		System.out.println(cnt);
	}

	static int[] dx = { -1, 0, 1, 0 }; // 북, 동, 남, 서
	static int[] dy = { 0, 1, 0, -1 };
	static int cnt = 0;

	static void cal(int r, int c, int d) {
		if (arr[r][c] == 0) {
			arr[r][c] = -1;
			cnt++;
		}

		boolean flag = false;
		int origin = d;
		for (int i = 0; i < 4; i++) {
			int dir = (d + 3) % 4;
			int x = dx[dir] + r;
			int y = dy[dir] + c;

			if (x >= 0 && y >= 0 && x < n && y < m && arr[x][y] == 0) {
				cal(x, y, dir);
				flag = true;
				break;
			}
			d = (d + 3) % 4;
		}
		
		if(!flag) { // 네 방향 모두 이미 청소되어있거나 벽인 경우
			int nextdir = (origin + 2) % 4;
			int x = dx[nextdir] + r;
			int y = dy[nextdir] + c;
			
			if(x >= 0 && y >= 0 && x < n && y < m ) {
				if(arr[x][y] != 1)	{
					cal(x, y, origin);
				}
			}
		}
	}
}
