import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj26069 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> hs = new HashSet<>();
		hs.add("ChongChong");
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			
			if(hs.contains(A) || hs.contains(B)) {
				hs.add(A);
				hs.add(B);
			}
		}
		
		System.out.println(hs.size());
	}
}
