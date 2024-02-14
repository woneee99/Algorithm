import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1238 {
	static int N;
	static ArrayList<Road>[] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			map[s].add(new Road(e, t));
		}
		
		int max = 0;
		int[] res = new int[N+1];
		for(int i=1; i<=N; i++) {
			if(i == X) continue;
			res[i] = cal(i, X);
		}
		for(int i=1; i<=N; i++) {
			if(i == X) continue;
			res[i] += cal(X, i);
			max = Math.max(max, res[i]);
		}
		
		System.out.println(max);
	}
	static int cal(int start, int end) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, 987654321);
		dist[start] = 0;
			
		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.add(new Road(start, 0));
		
		while(!pq.isEmpty()) {
			Road road = pq.poll();
			int y = road.end;
			
			if(y == end) {
				return dist[y];
			}
			
			for(int s=0; s<map[y].size(); s++) {
				int nowStart = map[y].get(s).end;
				int nowCost = map[y].get(s).cost;
				
				if(dist[nowStart] > nowCost + dist[y]) {
					dist[nowStart] = nowCost + dist[y];
					pq.add(new Road(nowStart, dist[nowStart]));
				}
			}
		}
		return 0;
	}
	static class Road implements Comparable<Road>{
		int end;
		int cost;
		
		public Road(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Road o) {
			return this.cost - o.cost;
		}
		
	}
}
