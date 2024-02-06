import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1976 {
	static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		StringTokenizer st = null;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1) union(i, j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int[] route = new int[M];
		for(int i=0; i<M; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean res = false;
		int start = find(route[0]);
		for(int i=1; i<M; i++) {
			if(start != find(route[i])) {
				res = true;
				break;
			}
		}
		
		System.out.println(res ? "NO" : "YES");
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			if(x < y) parent[y] = x;
			else parent[x] = y;
		}
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
}
