import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17828 {
	
	static int N, X;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		char[] word = new char[N+1];
		
		if( N > X || 26 * N < X) System.out.println("!");
		else {
			for(int i=0; i<N; i++) word[i] = 'A';
			X -= N;
			
			for(int i=N-1; i>=0; --i) {
				int tmp = Math.min(X, 25);
				word[i] += tmp;
				X -= tmp;
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<N; i++) {
				sb.append(word[i]);
			}
			System.out.println(sb.toString());
		}
	}
}
