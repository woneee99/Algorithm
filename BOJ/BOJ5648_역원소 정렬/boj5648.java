import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj5648 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String[] val = new String[n];
		
		int idx = 0;
		while(st.hasMoreTokens()) {
			val[idx++] = st.nextToken();
		}
		
		String line = "";
		while((line = br.readLine()) != null) {
			st = new StringTokenizer(line);
			while(st.hasMoreTokens()) {
				val[idx++] = st.nextToken();
			}
		}
		
		long[] res = new long[n];
		for(int i=0; i<n; i++) {
			StringBuilder sb = new StringBuilder(val[i]);
			res[i] = Long.parseLong(sb.reverse().toString());
		}
		Arrays.sort(res);
		
		StringBuilder sb = new StringBuilder();
		for(long i : res) {
			sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
}
