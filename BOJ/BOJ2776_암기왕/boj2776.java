import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj2776 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashSet<Integer> look = new HashSet<>();
			for(int i=0; i<N; i++) {
				look.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(look.contains(num)) {
					sb.append(1);
				}
				else sb.append(0);
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
