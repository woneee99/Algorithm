import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj3758 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 팀 수
			int k = Integer.parseInt(st.nextToken()); // 문제 수
			int t = Integer.parseInt(st.nextToken()); // 내 팀 id
			int m = Integer.parseInt(st.nextToken()); 
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			int[] cnt = new int[n+1];
			int[] last = new int[n+1];
			int[][] score = new int[n+1][k+1];
			int[] sum = new int[n+1];
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine()); 
				int id = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken()); //문제 번호
				int s = Integer.parseInt(st.nextToken()); // 점수
				
				score[id][num] = Math.max(score[id][num], s);
				cnt[id]++;
				last[id] = i;
			}
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=k; j++) {
					sum[i] += score[i][j];
				}
				pq.add(new Node(i, sum[i], cnt[i], last[i]));
			}
			
			int idx = 1;
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				if(node.id == t) {
					sb.append(idx).append("\n");
					break;
				}
				idx++;
			}
		}
		System.out.println(sb.toString());
	}
	static class Node implements Comparable<Node>{
		int id;
		int score;
		int cnt;
		int last;
		
		public Node(int id, int score, int cnt, int last) {
			this.id = id;
			this.score = score;
			this.cnt = cnt;
			this.last = last;
		}

		@Override
		public int compareTo(Node o) {
			if(this.score == o.score) {
				if(this.cnt == o.cnt) return this.last - o.last;
				return this.cnt - o.cnt; 
			}
			return o.score - this.score;
		}
	}
}
