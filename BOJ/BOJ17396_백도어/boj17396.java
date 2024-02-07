import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj17396 {
	static int N;
	static int[] spot;
	static ArrayList<Champion>[] champion;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		spot = new int[N];
		for(int i=0; i<N; i++) {
			spot[i] = Integer.parseInt(st.nextToken());
		}
		
		champion = new ArrayList[N];
		for(int i=0; i<N; i++) {
			champion[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			champion[a].add(new Champion(b, t));
			champion[b].add(new Champion(a, t));
			
		}
		
		System.out.println(dijkstra(0, N-1));
		
	}
	
	static long dijkstra(int start, int end) {
		long[] dist = new long[N];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Champion> pq = new PriorityQueue<>();
		pq.add(new Champion(start, 0));
		boolean[] chk = new boolean[N];
		while(!pq.isEmpty()) {
			Champion pion = pq.poll();
			int now = pion.end;
			
			if(now == end) {
				return dist[end];
			}
			
			if(chk[now]) continue;
			chk[now] = true;
			
			for(int i=0; i<champion[now].size(); i++) {
				int who = champion[now].get(i).end;
				long time = champion[now].get(i).time;
				
				if(chk[who] || (who != end && spot[who] == 1)) continue;
				if(dist[who] > time + dist[now]) {
					dist[who] = time + dist[now];
					pq.add(new Champion(who, dist[who]));
				}
			}
		}
		return -1;
	}
	
	static class Champion implements Comparable<Champion>{
		int end;
		long time;
		
		public Champion(int end, long time) {
			this.end = end;
			this.time = time;
		}

		@Override
		public int compareTo(Champion o) {
			if(this.time - o.time > 0) return 1;
			else return -1;
		}
	}
}
