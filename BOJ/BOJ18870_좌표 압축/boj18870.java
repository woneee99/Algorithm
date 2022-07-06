import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj18870 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] sorted = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sorted[i] = arr[i];
		}

		Arrays.sort(sorted);

		int row = 0;
		for (int i : sorted) {
			if (!map.containsKey(i)) {
				map.put(i, row++);
			}
		}

		for (int i = 0; i < n; i++) {
			bw.write(map.get(arr[i]) + " ");
		}

		bw.flush();
		bw.close();
	}

}
