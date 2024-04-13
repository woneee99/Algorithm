import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1922 {
	static int[] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		PriorityQueue<Node> arr = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr.add(new Node(a, b, c));
		}
		
		dist = new int[N+1];
		for(int i=0; i<=N; i++) dist[i] = i;
		
		int res = 0;
		for(int i=0; i<M; i++) {
			Node node = arr.poll();
			int a = node.start;
			int b = node.end;
			
			if(find(a) == find(b)) continue;
			union(a, b);
			res += node.cost;
		}
		System.out.println(res);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x > y) dist[x] = y;
		else dist[y] = x;
	}
	
	static int find(int x) {
		if(dist[x] == x) return dist[x];
		return find(dist[x]);
	}
	
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int cost;
		
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
