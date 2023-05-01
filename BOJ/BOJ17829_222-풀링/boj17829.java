import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17829 {
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			int[][] cal = new int[N/2][N/2];
			
			for(int i=0, x=0; i<N; i+=2, x++) {
				for(int j=0, y=0; j<N; j+=2, y++) {
					cal[x][y] = pooling(arr, i, j);
				}
			}
			
			N /= 2;
			if(N == 1) {
				System.out.println(cal[0][0]);
				break;
			}
			
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				arr[i] = cal[i].clone();
			}
		}
	}
	
	static int pooling(int[][] cal, int x, int y) {
		int[] res = new int[4];
		int cnt = 0;
		for(int i=x; i<x+2; i++) {
			for(int j=y; j<y+2; j++) {
				res[cnt++] = (cal[i][j]);
			}
		}

		Arrays.sort(res);
		return res[2];
		
	}
}
