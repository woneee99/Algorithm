import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1204 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[101];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
			
			int max = 0, res = 0;
			for(int j=0; j<=100; j++) {
				max = arr[j] >= max ? arr[j] : max;
				res = arr[j] >= max ? j : res;
			}
			
			sb.append("#").append(n).append(" ").append(res).append("\n");
			
		}
		System.out.println(sb.toString());
	}

}
