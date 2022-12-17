import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2343 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());

		int start = 0, end = arr[0];
		for (int i = 1; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end += arr[i];
			start = Math.max(start, arr[i]);
		}

		int res = 0;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (cal(mid)) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(res);
	}

	static int[] arr;
	static int n, m;

	static boolean cal(int res) {
		int cnt = 0, chk = 0;
		for (int i = 0; i < n; i++) {
			if (chk + arr[i] > res) {
				cnt++;
				chk = arr[i];
			} else {
				chk += arr[i];
			}
		}

		return (cnt>=m) ? false : true;
	}
}
