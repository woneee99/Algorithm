import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dist = new int[N][2];
		int[] deep = new int[N];
		int sum = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dist[i][0] = Integer.parseInt(st.nextToken());
			dist[i][1] = Integer.parseInt(st.nextToken());
			if(i == 0) continue;
			deep[i] = Math.abs(dist[i-1][0] - dist[i][0]) + Math.abs(dist[i-1][1] - dist[i][1]);
			sum += deep[i];
		}
		
		int max = 0;
		for(int i=1; i<N-1; i++) {
			int cal = Math.abs(dist[i-1][0] - dist[i+1][0]) + Math.abs(dist[i-1][1] - dist[i+1][1]);
			max = Math.max(max, deep[i]+deep[i+1]-cal);
		}
		System.out.println(sum - max);
	}

}
