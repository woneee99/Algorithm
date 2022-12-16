import java.io.*;
import java.util.*;

public class boj2589 {
	static char[][] arr;
	static boolean[][] chk;
	static int l, r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new char[l][r];
		chk = new boolean[l][r];
		
		for (int i = 0; i < l; i++) {
			String Line = br.readLine();
			for (int j = 0; j < r; j++) {
				arr[i][j] = Line.charAt(j);
			}
		}

		int max = 0;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < r; j++) {
				if (arr[i][j] == 'L') {
					chk = new boolean[l][r];
					int result = cal(i, j);
					max = Math.max(result, max);
				}
			}
		}

		System.out.println(max);
	}

	static int cal(int left, int right) {
		int res = 0;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		chk[left][right] = true;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { left, right, 0 });

		while (!q.isEmpty()) {
			int[] pol = q.poll();
			int x = pol[0];
			int y = pol[1];
			int count = pol[2];
			
			for (int i = 0; i < 4; i++) {
				int x1 = x + dx[i];
				int y1 = y + dy[i];

				if (x1 < 0 || y1 < 0 || x1 >= l || y1 >= r || arr[x1][y1] == 'W')
					continue;

				if (!chk[x1][y1]) {
					res = Math.max(res, count + 1);
					chk[x1][y1] = true;
					q.add(new int[] { x1, y1, count + 1 });
				}
			}
		}
		return res;
	}

}
