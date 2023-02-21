import java.io.*;
import java.util.*;

public class boj1987 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			String Line = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = Line.charAt(j) - 'A';
			}
		}
		chk = new boolean[26];
		chk[arr[0][0]] = true;
		cal(0, 0, 1);
		System.out.println(cnt);
	}

	static int[][] arr;
	static boolean[] chk;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt = 0;

	static void cal(int wx, int wy, int depth) {
		for (int i = 0; i < 4; i++) {
			int x = wx + dx[i];
			int y = wy + dy[i];

			if (x >= arr.length || x < 0 || y >= arr[0].length || y < 0)
				continue;
			int now = arr[x][y];
			if (!chk[now]) {
				chk[now] = true;
				cal(x, y, depth + 1);
				chk[now] = false;
			} else {
				cnt = cnt < depth ? depth : cnt;
			}
		}
	}

}