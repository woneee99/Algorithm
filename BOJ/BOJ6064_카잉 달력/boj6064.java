import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj6064 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;

			boolean chk = false;
			int cnt = 0;
			for(int i=x; i<(N*M); i+=M) {
				if(i % N == y) {
					cnt = i+1;
					chk = true;
					break;
				}
			}

			cnt = chk ? cnt : -1;
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
