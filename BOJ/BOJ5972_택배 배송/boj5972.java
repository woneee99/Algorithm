import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj5972 {
	static int N;
	static ArrayList<Route>[] route;
	static final int INF = 50_000_000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		route = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			route[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			route[a].add(new Route(b, c));
			route[b].add(new Route(a, c));
		}
		
		System.out.println(dijkstra(1, N));
	}
	
	static int dijkstra(int start, int end) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Route> pq = new PriorityQueue<>();
		pq.add(new Route(start, 0));
		while(!pq.isEmpty()) {
			Route poll = pq.poll();
			
			if(poll.end == end) {
				return poll.cost;
			}
			for(int i=0; i<route[poll.end].size(); i++) {
				int nowEnd = route[poll.end].get(i).end;
				int nowCost = route[poll.end].get(i).cost;
				
				if(dist[nowEnd] > dist[poll.end] + nowCost) {
					dist[nowEnd] = dist[poll.end] + nowCost;
					pq.add(new Route(nowEnd, dist[nowEnd]));
				}
			}
		}
		return 0;
	}
	
	static class Route implements Comparable<Route>{
		int end;
		int cost;
		
		public Route(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Route o) {
			return this.cost - o.cost;
		}
	}
}
