import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj2583 {
	static int[][] arr;
	static boolean[][] chk;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int sz = Integer.parseInt(st.nextToken());

		arr = new int[m][n];
		chk = new boolean[m][n];

		for (int i = 0; i < sz; i++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());

			for (int j = lx; j < rx; j++) {
				for (int k = ly; k < ry; k++) {
					arr[j][k] = 1;
				}
			}
		}

		ArrayList<Integer> sol = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!chk[i][j] && arr[i][j] == 0) {
					cnt++;
					sol.add(dfs(i, j));
				}
			}
		}
		Collections.sort(sol);
		System.out.println(cnt);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sol.size(); i++) {
			sb.append(sol.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}

	static int dfs(int x, int y) {
		int count = 1;
		chk[x][y] = true;

		if (x - 1 >= 0 && y < n && !chk[x - 1][y] && arr[x - 1][y] == 0)
			count += dfs(x - 1, y);
		if (x + 1 < m && y < n && !chk[x + 1][y] && arr[x + 1][y] == 0)
			count += dfs(x + 1, y);
		if (x < m && y + 1 < n && !chk[x][y + 1] && arr[x][y + 1] == 0)
			count += dfs(x, y + 1);
		if (x < m && y - 1 >= 0 && !chk[x][y - 1] && arr[x][y - 1] == 0)
			count += dfs(x, y - 1);

		return count;
	}
}
