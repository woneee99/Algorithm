import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj9019 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			cal(a, b);
		}
		System.out.println(sb.toString());
		
	}
	static StringBuilder sb = new StringBuilder();
	static void cal(int a, int b) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(a, ""));
		boolean[] check = new boolean[10000];
		check[a] = true;
		
		while(!q.isEmpty()) {
			int sz = q.size();
			for(int i=0; i<sz; i++) {
				Node pol = q.poll();
				
				if(pol.num == b) {
					sb.append(pol.res).append("\n");
					return;
				}
				
				// 1. D
				int dNum = (pol.num * 2) % 10000;
				if(!check[dNum]) {
					check[dNum] = true;
					q.add(new Node(dNum, pol.res + "D"));
				}
				
				// 2. S
				int sNum = pol.num == 0 ? sNum = 9999 : pol.num -1;		
				if(!check[sNum]) {
					check[sNum] = true;
					q.add(new Node(sNum, pol.res + "S"));
				}
			
				// 3. L
				int lNum = (pol.num % 1000) * 10 + pol.num / 1000;
				if(!check[lNum]) {
					check[lNum] = true;
					q.add(new Node(lNum, pol.res + "L"));
				}
				
				// 4. R
				int r = pol.num / 10 + pol.num % 10 * 1000;
				if(!check[r]) {
					check[r] = true;
					q.add(new Node(r, pol.res + "R"));
				}
			}
		}
	}
	
	static class Node {
		int num;
		String res;
		
		public Node(int num, String res) {
			this.num = num;
			this.res = res;
		}
	}
}
