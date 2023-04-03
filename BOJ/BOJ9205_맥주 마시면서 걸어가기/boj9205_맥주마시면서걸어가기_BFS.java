package boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj9205_맥주마시면서걸어가기_BFS {
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int homeX = Integer.parseInt(st.nextToken()); 
			int homeY = Integer.parseInt(st.nextToken()); 
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<2; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int festX = Integer.parseInt(st.nextToken()); 
			int festY = Integer.parseInt(st.nextToken()); 
			
			Queue<int[] > q = new ArrayDeque<>();
			q.add(new int[] {homeX, homeY});
			
			boolean[] chk = new boolean[N];
			boolean res = false;
			while(!q.isEmpty()) {
				int[] pol = q.poll();
				
				if( (Math.abs(pol[0] - festX) + Math.abs(pol[1] - festY)) <= 1000 ) {
					res = true;
					break;
				}
				
				for(int i=0; i<N; i++) {
					int dis = Math.abs(pol[0] - map[i][0]) + Math.abs(pol[1] - map[i][1]);
					if(chk[i] || dis > 1000) continue;
					
					chk[i] = true;
					q.add(new int[] {map[i][0], map[i][1]});
				}
			}
			
			sb.append(res ? "happy" : "sad").append("\n");

		}
		
		System.out.println(sb.toString());
	}

}
