import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1744_1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int res = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (i == 0 || (arr[i] + arr[i - 1] >= arr[i] * arr[i - 1])) { // 곱보다 합이 더 큰 경우
				res += arr[i];
			} else if (arr[i - 1] < 0 && (i - 2 >= 0 && ((i - 2) % 2) == 0)) { // 음수가 짝수개
				res += arr[i];
			} else {
				res += arr[i] * arr[i - 1];
				i--;
			}
		}
		
		System.out.println(res);
	}
}
