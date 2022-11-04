import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2447 {
	static StringBuilder sb;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine()); 

		arr = new char[n][n];
		star(0, 0, false, n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void star(int x, int y, boolean chk, int n) {
		if (chk) {
			for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		if (n == 1) {
			arr[x][y] = '*';
			return;
		}
		
		int size = n / 3;
		int cnt = 0;

		for (int i = x; i < x + n; i += size) {
			for (int j = y; j < y + n; j += size) {
				cnt++;
				if (cnt == 5) {
					star(i, j, true, size);
				} else
					star(i, j, false, size);
			}
		}

	}
}
