import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0, end = 0;
		long res = 0;
		int cnt = 0;
		while (true) {
			if(res >= m) {
				res -= arr[start++];
			}
			else if(end >= n) break;
			else {
				res += arr[end++];
			}
			if (res == m) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
