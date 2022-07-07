import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14888 {
	static int[] arr, cal;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		arr = new int[n];
		cal = new int[4]; // + - * %

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		back(1, arr[0]);
		System.out.println(max);
		System.out.println(min);

	}

	static void back(int depth, int result) {
		if (depth == arr.length) {
			max = result > max ? result : max;
			min = result < min ? result : min;
			return;
		}

		if (cal[0] > 0) { // +
			cal[0]--;
			back(depth + 1, result + arr[depth]);
			cal[0]++;
		}
		if (cal[1] > 0) { // -
			cal[1]--;
			back(depth + 1, result - arr[depth]);
			cal[1]++;
		}
		if (cal[2] > 0) { // *
			cal[2]--;
			back(depth + 1, result * arr[depth]);
			cal[2]++;
		}
		if (cal[3] > 0) { // %
			cal[3]--;
			back(depth + 1, result / arr[depth]);
			cal[3]++;
		}
	}

}
