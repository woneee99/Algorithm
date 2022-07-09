import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n + 1][n + 1];
		int[][] newArr = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (j > 1) {
					newArr[i][j] = arr[i][j] + newArr[i][j - 1];
				} else {
					if (i == 1)
						newArr[i][j] = arr[i][j];
					else
						newArr[i][j] = newArr[i - 1][n] + arr[i][j];
				}
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int sum = 0;
			for (int j = x2; j >= x1; j--) {
				int y = newArr[j][y1 - 1];
				if (y == 0) {
					sum += newArr[j][y2] - newArr[j - 1][n];
				} else
					sum += newArr[j][y2] - y;
			}
			sb.append(sum).append("\n");
		}

		System.out.println(sb.toString());
	}

}
