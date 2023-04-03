package boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9205_맥주마시면서걸어가기_Floyd {
	static int[][] map;
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int V = N+2;
			map = new int[V][2];
			
			int[][] dir = new int[V][V];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[0][0] = Integer.parseInt(st.nextToken()); 
			map[0][1] = Integer.parseInt(st.nextToken()); 
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<2; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			map[N+1][0] = Integer.parseInt(st.nextToken()); 
			map[N+1][1] = Integer.parseInt(st.nextToken()); 
			
			for(int i=0; i<V; i++) {
				for(int j=0; j<V; j++) {
					if( i == j ) continue;
					int dis = Math.abs(map[i][0] - map[j][0]) + Math.abs(map[i][1] - map[j][1]);
					
					if( dis > 1000 ) dir[i][j] = INF;
					else dir[i][j] = dis;
				}
			}
			
			for(int k=0; k<V; k++) {
				for(int i=0; i<V; i++) {
					if( k == i ) continue;
					for(int j=0; j<V; j++) {
						if(k == j || i == j) continue;
						dir[i][j] = Math.min(dir[i][j], dir[i][k] + dir[k][j]);
					}
				}
			}
			sb.append(dir[0][V-1] >= INF ? "sad" : "happy").append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
