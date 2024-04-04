import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj22858 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] map = new int[N+1];
		int[] S = new int[N+1];
		int[] D = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
			map[i] = S[i];
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<K; i++) {
			for(int j=1; j<=N; j++) {
				map[D[j]] = S[j];
			}
			for(int j=1; j<=N; j++) {
				S[j] = map[j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(map[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
