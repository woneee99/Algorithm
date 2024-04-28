import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj4195 {
	static int[] parent;
	static int[] level;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int F = Integer.parseInt(br.readLine());

			parent = new int[F*2];
			level = new int[F*2];
			
			for(int i=0; i<F*2; i++) {
				parent[i] = i;
				level[i] = 1;
			}
			
			int idx = 0;
			HashMap<String, Integer> hm = new HashMap<>();
			for(int i=0; i<F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String one = st.nextToken();
				String two = st.nextToken();
				
				if(!hm.containsKey(one)) {
					hm.put(one, idx++);
				}
				if(!hm.containsKey(two)) {
					hm.put(two, idx++);
				}
				
				sb.append(union(hm.get(one), hm.get(two))).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	static public int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static public int union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			parent[y] = x;
			level[x] += level[y];
			
			level[y] = 1;
		}
		
		return level[x];
	}
}
