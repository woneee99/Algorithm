import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj1446 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
	
		ArrayList<Road> road = new ArrayList<>();
		int[] dp = new int[D+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			road.add(new Road(start, end, length));
		}
		
		Collections.sort(road);
		int idx = 0;
		for(int d=1; d<=D; d++) {
			dp[d] = dp[d-1] + 1;
			
			while(idx < N) {
				Road r = road.get(idx);
				if(r.end == d) {
					dp[d] = Math.min(dp[d], r.length + dp[r.start]);
					idx++;
				}
				else break;
			}
		}
		
		System.out.println(dp[D]);
	}
	static class Road implements Comparable<Road>{
		int start;
		int end; 
		int length;
		
		public Road(int start, int end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
		}

		@Override
		public int compareTo(Road o) {
			return this.end - o.end;
		}
	}
}
