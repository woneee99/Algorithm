package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_4014_활주로건설 {
	static int N, X;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken()); // 길이
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int res = 0;
			
			// 가로 체크
			for(int i=0; i<N; i++) {
				int now = map[i][0], cnt = 1;
				boolean chk = true;
				for(int j=1; j<N; j++) {
					if(now < map[i][j]) { // 큰 건물 만났을 때
						if(map[i][j] - now != 1 || (cnt < X || cnt == 0)) {
							chk = false;
							break;
						}
						else {
							cnt = 1;
							now = map[i][j];
						}
					}
					else if(now > map[i][j]){ // 작은 친구들
						cnt = 1;
						
						if(now - map[i][j] != 1) {
							chk = false;
							break;
						}
						
						now = map[i][j];
						
						int x = j + 1;
						while( x < N) {
							if(map[i][x] == now) cnt++;
							else break;
							x++;
						}
						
						if(cnt < X) {
							chk = false;
							break;
						}
						cnt -= X;
						j = x - 1;
					}
					else { // 같은 친구들
						cnt++;
					}
				}
				
				if(chk) res++;
			}
			
			// 세로 체크
			for(int i=0; i<N; i++) {
				int now = map[0][i], cnt = 1;
				boolean chk = true;
				for(int j=1; j<N; j++) {
					if(now < map[j][i]) { 
						if(map[j][i] - now != 1 || cnt < X || cnt == 0) {
							chk = false;
							break;
						}
						else {
							cnt = 1;
							now = map[j][i];
						}
					}
					else if(now > map[j][i]){
						cnt = 1;
						if(now - map[j][i] != 1) {
							chk = false;
							break;
						}
						now = map[j][i];
						
						int x = j + 1;
						while( x < N) {
							if(map[x][i] == now) cnt++;
							else break;
							x++;
						}

						if(cnt < X) {
							chk = false;
							break;
						}
						cnt -= X;
						j = x - 1;
					}
					else cnt++;
				}
				if(chk) res++;
			}
			
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
		 
	}
}
