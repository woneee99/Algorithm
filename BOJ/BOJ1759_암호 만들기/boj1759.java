import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1759 {
	static String[] arr;
	static StringBuilder sb = new StringBuilder();
	static boolean[] chk;
	static int l;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken()); // 암호 개수
		int c = Integer.parseInt(st.nextToken());

		arr = new String[c];
		chk = new boolean[c];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			arr[i] = st.nextToken();
		}

		Arrays.sort(arr);

		cal(0, "", 0);
		System.out.println(sb.toString());
	}

	static void cal(int length, String res, int wc) {
		if (length == l) {
			int cnt = 0;
			if (res.contains("a")) cnt++;
			if (res.contains("e")) cnt++;
			if (res.contains("i")) cnt++;
			if (res.contains("o")) cnt++;
			if (res.contains("u")) cnt++;

			if ((l - cnt) < 2) return;
			else if (cnt == 0) return;
			else sb.append(res).append("\n");
		}

		for (int i = wc; i < arr.length; i++) {
			if (!chk[i]) {
				chk[i] = true;
				cal(length + 1, res + arr[i], i + 1);
				chk[i] = false;
			}
		}
	}
}
