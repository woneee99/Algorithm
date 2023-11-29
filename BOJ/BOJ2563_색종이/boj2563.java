import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2563 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[101][101];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nx = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken());
			
			for(int x=nx; x<nx+10; x++) {
				for(int y=ny; y<ny+10; y++) {
					if(x >= 100 || y >= 100) break;
					arr[x][y] = 1;
				}
			}
		}
		
		int res = 0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(arr[i][j] == 1) res++;
			}
		}
		System.out.println(res);
	}

}
