import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1707 {
	static boolean[] chk;
	static int[] colors;
	static ArrayList<Integer>[] arr;
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); //정점
			int v = Integer.parseInt(st.nextToken()); //간선
			
			arr = new ArrayList[u+1];
			for(int i=0; i<=u; i++) {
				arr[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<v; i++) {
				st = new StringTokenizer(br.readLine());
				int one = Integer.parseInt(st.nextToken());
				int two = Integer.parseInt(st.nextToken());
				arr[one].add(two);
				arr[two].add(one);
			}
			
			chk = new boolean[u+1];
			colors = new int[u+1];
			
			check = false;
			for(int i=1; i<=u; i++) {
				if(check) break;
				if(colors[i] == 0) {
					dfs(1, i);
//					bfs(1, i);
				}
			}
			if(check) sb.append("NO").append("\n");
			else sb.append("YES").append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int color, int x) {
		colors[x] = color;
		for(int val: arr[x]) {
			if(colors[val] == color) {
				check = true;
				return;
			}
			if(colors[val] == 0) {
				dfs(-color, val);
			}
		}
	}
	
	static void bfs(int color, int x) {
		colors[x] = color;
		Queue<Integer> q = new LinkedList<>();
		
		q.add(x);
		
		while(!q.isEmpty()) {
			int k = q.poll();
			
			for(int val: arr[k]) {
				if(colors[val] == 0) {
					colors[val] = -colors[k];
					q.add(val);
				}
				if(colors[val] == colors[k]) {
					check = true;
					return;
				}
			}
		}
		
	}
}
