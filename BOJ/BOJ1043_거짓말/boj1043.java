import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1043 {
	static boolean[] know;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		if(num == 0) {
			System.out.println(M);
			return;
		}
		
		know = new boolean[N+1];
		for(int i=0; i<num; i++) {
			know[Integer.parseInt(st.nextToken())] = true;
		}
		
		ArrayList<Integer>[] arr = new ArrayList[M];
		for(int i=0; i<M; i++) {
			arr[i] = new ArrayList<>();
		}
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int person = Integer.parseInt(st.nextToken());

			int x = Integer.parseInt(st.nextToken());
			arr[i].add(x);
			for(int j=1; j<person; j++) {
				int y = Integer.parseInt(st.nextToken());
				union(x, y);
				arr[i].add(y);
			}
		}
		
		int res = 0;
		for(int i=0; i<M; i++) {
			boolean check = false;
			for(int x : arr[i]) {
				if(know[find(x)]) {
					check = true;
					break;
				}
			}
			
			if(!check) res++;
		}
		
		System.out.println(res);
	}
	
	static int[] parent;
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(know[x]) parent[y] = x;
		else parent[x] = y;
	}
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
}
