import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2470 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int x = Integer.MAX_VALUE;
		int i = 0, j = n - 1;
		int ans1 = 0, ans2 = 0;

		while (i < j) {
			int sum = arr[i] + arr[j];
			int re = Math.abs(sum);

			if (x > re) {
				x = re;
				ans1 = arr[i];
				ans2 = arr[j];
			}
			if (sum > 0) {
				j--;
			} else {
				i++;
			}
		}

		System.out.println(ans1 + " " + ans2);
	}
}
