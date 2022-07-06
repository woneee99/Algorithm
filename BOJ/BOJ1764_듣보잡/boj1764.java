import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(br.readLine(), i);
		}

		int count = 0;
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			String check = br.readLine();
			if (map.containsKey(check)) {
				count++;
				arr.add(check);
			}
		}

		Collections.sort(arr);

		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i)).append("\n");
		}

		System.out.println(count);
		System.out.println(sb.toString());
	}

}
