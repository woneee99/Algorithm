import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj4158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) break;
			
			HashSet<Long> hs = new HashSet<>();
			for(int i=0; i<N; i++) {
				hs.add(Long.parseLong(br.readLine()));
			}
			
			int res = 0;
			for(int i=0; i<M; i++) {
				long cd = Long.parseLong(br.readLine());
				if(hs.contains(cd)) res++;
			}
			sb.append(res).append("\n");
		}

		System.out.println(sb.toString());
	}
}
