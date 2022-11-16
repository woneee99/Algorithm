import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj9372 {
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			arr = new ArrayList[n + 1];

			for (int i = 0; i <= n; i++) {
				arr[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				arr[num1].add(num2);
				arr[num2].add(num1);
			}

			boolean[] chk = new boolean[n + 1];
			cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (!chk[i]) {
					chk[i] = true;
					cal(chk, i);
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int cnt = 0;

	static void cal(boolean[] chk, int x) {
		for (int i = 0; i < arr[x].size(); i++) {
			if (!chk[arr[x].get(i)]) {
				chk[arr[x].get(i)] = true;
				cnt++;
				cal(chk, arr[x].get(i));
			}
		}
	}
}
