import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1068 {
	static boolean[] chk;
	static int[] parent;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		parent = new int[n];
		chk = new boolean[n];

		int root = 0;
		for (int i = 0; i < n; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
			if (parent[i] == -1) root = i;
		}

		int q = Integer.parseInt(br.readLine()); 
		deleteCal(q, n);

		cntCal(root, n);
		System.out.println(count);
	}

	static void deleteCal(int x, int n) {
		parent[x] = -2;
		for (int i = 0; i < n; i++) {
			if (parent[i] == x) {
				deleteCal(i, n);
			}
		}
	}

	static void cntCal(int x, int n) {
		chk[x] = true;
		boolean c = true;

		if (parent[x] != -2) {
			for (int i = 0; i < n; i++) {
				if (parent[i] == x && !chk[i]) {
					cntCal(i, n);
					c = false;
				}
			}
			if (c) count++;
		}
	}
}
