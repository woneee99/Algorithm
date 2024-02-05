import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1504 {
	static final int INF = 987654321;
	static int[] dist;
	static boolean[] chk;
	static ArrayList<Graph>[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new Graph(b, c));
			arr[b].add(new Graph(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		chk = new boolean[N+1];
		
		long res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);
		
		long res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);
		
		long res = Math.min(res1, res2);
		long ans = res >= INF ? -1 : res;
		System.out.println(ans);
	}
	static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		Arrays.fill(chk, false);
		
		PriorityQueue<Graph> pq = new PriorityQueue<>();
		pq.offer(new Graph(start, 0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Graph graph = pq.poll();
			int now = graph.end;
			
			if(chk[now]) continue;
			chk[now] = true;
				
			for(Graph g : arr[now]) {
				if(!chk[g.end] && dist[g.end] > g.dir + dist[now]) {
					dist[g.end] = g.dir + dist[now];
					pq.add(new Graph(g.end, dist[g.end]));
				}
			}
		}
		
		return dist[end];
	}
	static class Graph implements Comparable<Graph>{
		int end;
		int dir;
		
		public Graph(int end, int dir) {
			this.end = end;
			this.dir = dir;
		}

		@Override
		public int compareTo(Graph o) {
			return this.dir - o.dir;
		}
	}
}
