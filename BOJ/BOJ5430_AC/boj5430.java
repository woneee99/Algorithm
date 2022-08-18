import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj5430 {
	static Deque<String> pl;
	static boolean check = false;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			
			pl = new ArrayDeque<>();
			for (int j = 0; j < n; j++) {
				pl.add(st.nextToken());
			}
			cal(p);
		}
		System.out.println(sb.toString());
	}

	static void cal(String p) {
		check = false;
		for (int j = 0; j < p.length(); j++) {
			char c = p.charAt(j);
			if (c == 'R') {
				check = !check;
				continue;
			}
			if (check) {
				if(pl.pollLast() == null) {
					sb.append("error").append("\n");
					return;
				}
			} else {
				if(pl.pollFirst() == null) {
					sb.append("error").append("\n");
					return;
				}
			}
		}
		sb();
	}

	static void sb() {
		sb.append("[");
		int sz = pl.size();
		if(sz > 0) {
			if (check) {
				for (int j = 0; j < sz; j++) {
					sb.append(pl.pollLast());
					if (j != sz - 1)
						sb.append(",");
				}
			} else {
				for (int j = 0; j < sz; j++) {
					sb.append(pl.pollFirst());
					if (j != sz - 1)
						sb.append(",");
				}
			}
		}
		sb.append("]").append("\n");
	}
}
