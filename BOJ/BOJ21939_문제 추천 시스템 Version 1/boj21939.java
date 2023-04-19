import java.io.*;
import java.util.*;

public class boj21939 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		TreeMap<Integer, Integer> tm = new TreeMap<>();
		TreeSet<problem> ts = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken()); // 문제 번호
			int L = Integer.parseInt(st.nextToken()); // 난이도

			ts.add(new problem(L, P));
			tm.put(P, L);
		}

		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String[] line = br.readLine().split(" ");
			int x = Integer.parseInt(line[1]);
			switch (line[0]) {
			case "add": {
				ts.add(new problem(Integer.parseInt(line[2]), x));
				tm.put(x, Integer.parseInt(line[2]));
				break;
			}
			case "recommend": {
				sb.append(x == -1 ? ts.first().no : ts.last().no).append("\n");
				break;
			}
			case "solved": {
				ts.remove(new problem(tm.get(x), x));
				tm.remove(x);
				break;
			}
			}
		}

		System.out.println(sb.toString());
	}

	static class problem implements Comparable<problem> {
		int no; // 문제 번호
		int difficulty; // 난이도

		public problem(int difficulty, int no) {
			this.no = no;
			this.difficulty = difficulty;
		}

		@Override
		public int compareTo(problem o) {
			if (o.difficulty == this.difficulty) return this.no - o.no;
			return this.difficulty - o.difficulty;
		}
	}
}