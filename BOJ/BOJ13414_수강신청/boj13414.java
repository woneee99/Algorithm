import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class boj13414 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		LinkedHashSet<String> hs = new LinkedHashSet<>();
		for(int i=0; i<L; i++) {
			String num = br.readLine();
			if(hs.contains(num)) hs.remove(num);
			hs.add(num);
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(String str : hs) {
			sb.append(str).append("\n");
			if(++cnt == K) break;
		}
		
		System.out.println(sb);
	}

}
