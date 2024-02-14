import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1238_1 {
	static int N;
	static ArrayList<Road>[] map;
	static ArrayList<Road>[] reMap;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N+1];
		reMap = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			map[i] = new ArrayList<>();
			reMap[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			map[s].add(new Road(e, t));
			reMap[e].add(new Road(s, t));
		}
		
		int max = 0;
		int[] go = cal(map, X);
		int[] end = cal(reMap, X);
		
		for(int i=1; i<=N; i++) {
			max = Math.max(max, go[i] + end[i]);
		}
		System.out.println(max);
	}
	static int[] cal(ArrayList<Road>[] arr, int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, 987654321);
		dist[start] = 0;
			
		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.add(new Road(start, 0));
		
		while(!pq.isEmpty()) {
			Road road = pq.poll();
			int y = road.end;
			
			for(Road now : arr[y]) {
				if(dist[now.end] > now.cost + dist[y]) {
					dist[now.end] = now.cost + dist[y];
					pq.add(new Road(now.end, dist[now.end]));
				}
			}
		}
		return dist;
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
