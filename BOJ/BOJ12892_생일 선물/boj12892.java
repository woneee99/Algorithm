import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj12892 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken()); 
		
		Node[] cost = new Node[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken()); // 선물 가격
			int V = Integer.parseInt(st.nextToken()); // 만족도
			cost[i] = new Node(P, V);
		}
		
		Arrays.sort(cost);
		
		long max = 0, sum = 0;
		int start = 0, end = 0;
		while(true) {			
			while(end < N && cost[end].price - cost[start].price < D) {
				sum += cost[end].val;
				end++;
			}
			max = Math.max(max, sum);
			
			if(end == N) break;
			sum -= cost[start].val;
			start++;
		}
	
		System.out.println(max);
	}
	static class Node implements Comparable<Node> {
		int price;
		int val;
		
		Node(int p, int v) {
			price = p;
			val = v;
		}
		@Override
		public int compareTo(Node o) {
			return this.price - o.price;
		}
	}
}
