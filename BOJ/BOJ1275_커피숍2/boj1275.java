import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1275 {
	static long[] arr, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		arr = new long[n+1];

		tree = new long[n*4];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		init(1, 1, n);
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(x > y) sb.append(sum(1, 1, n, y, x)).append("\n");
			else sb.append(sum(1, 1, n, x, y)).append("\n");
			update(1, 1, n, a, b - arr[a]);
			arr[a] = b;
			
		}
		System.out.println(sb.toString());
	}

	static long init(int node, int start, int end) {
		// leaf 노드일 경우
		if (start == end) {
			return tree[node] = arr[start];
		}

		return tree[node] = init(node * 2, start, (start + end) / 2) + init(node * 2 + 1, (start + end) / 2 + 1, end);
	}

	static void update(int node, int start, int end, int idx, long diff) {
		if (start > idx || end < idx)
			return;

		tree[node] += diff;

		// 리프노드가 아니면
		if (start != end) {
			update(node * 2, start, (start + end) / 2, idx, diff);
			update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
		}
	}

	static long sum(int node, int start, int end, int left, int right) {
		if(start > right || end < left) return 0;
		
		if(left <= start && end <= right) return tree[node];
		
		return sum(node*2, start, (start+end)/2, left, right) + sum(node*2+1, (start+end)/2+1, end, left, right);
	}
}
