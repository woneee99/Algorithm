import java.io.*;
import java.util.*;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class boj15686 {
	static int[][] arr;
	static int n, m, ans = Integer.MAX_VALUE;
	static ArrayList<Point> check = new ArrayList<>();
	static ArrayList<Point> home = new ArrayList<>();
	static boolean[] chk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					home.add(new Point(i, j));
				}
				if (arr[i][j] == 2) {
					check.add(new Point(i, j));
				}
			}
		}
		chk = new boolean[check.size()];
		cal(0, 0);
		System.out.println(ans);
	}

	static void cal(int cnt, int start) {
		if (cnt == m) {
			int tmp = 0;
			for (int i = 0; i < home.size(); i++) {
				int temp = Integer.MAX_VALUE;
				for (int j = 0; j < check.size(); j++) {
					if (chk[j]) {
						int w = Math.abs(home.get(i).x - check.get(j).x) + Math.abs(home.get(i).y - check.get(j).y);
						temp = Math.min(temp, w);
					}
				}
				tmp += temp;
			}
			ans = Math.min(tmp, ans);
			return;
		}

		for (int i = start; i < check.size(); i++) {
			chk[i] = true;
			cal(cnt + 1, i + 1);
			chk[i] = false;
		}
	}

}
