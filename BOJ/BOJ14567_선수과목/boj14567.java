import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj14567 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] list = new boolean[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A][B] = true;
		}
		
		int[] res = new int[N+1];
		for(int i=1; i<=N; i++) {
			res[i] = 1;
			for(int j=1; j<i; j++) {
				if(list[j][i]) {
					res[i] = Math.max(res[j] + 1, res[i]);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			bw.write(res[i] + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
