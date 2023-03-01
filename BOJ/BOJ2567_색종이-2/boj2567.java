import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2567 {
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		arr = new int[101][101];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					arr[j][k] = 1;
				}
			}
		}
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int cnt = 0;
		for(int i=1; i<101; i++) {
			for(int j=1; j<101; j++) {
				if(arr[i][j] == 1) {
					for(int k=0; k<4; k++) {
						int x = dx[k] + i;
						int y = dy[k] + j;
						
						if(x < 1 || y < 1 || x > 100 || y > 100) continue;
						if(arr[x][y] == 0) cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}

}
