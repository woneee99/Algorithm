import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1744 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int check = -1;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		int sum = 0;
		for (int i = n - 1; i >= 0; i -= 2) {
			if (i - 1 >= 0) {
				if (arr[i] == 0 || arr[i] < 0 || arr[i - 1] == 0 || arr[i - 1] < 0) {
					check = i;
					break;
				} else
					sum += arr[i] + arr[i - 1] < (arr[i] * arr[i - 1]) ? (arr[i] * arr[i - 1]) : arr[i] + arr[i - 1];
			} else
				sum += arr[i];
		}

		for (int i = 0; i <= check; i += 2) {
			if (i + 1 <= check) {
				sum += arr[i] + arr[i + 1] < (arr[i] * arr[i + 1]) ? (arr[i] * arr[i + 1]) : arr[i] + arr[i + 1];
			} else
				sum += arr[i];
		}
		System.out.println(sum);
	}

}
