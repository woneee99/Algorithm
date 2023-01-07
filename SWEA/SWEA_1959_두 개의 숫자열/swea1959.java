import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1959 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			int[] brr = new int[m];
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				brr[j] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0, minus = Math.abs(n-m);
			for(int j=0; j<=minus; j++) {
				int chk = 0;
				if(n > m) {
					for(int k=0; k<m; k++) {
						chk += (arr[j+k] * brr[k]);
					}
				}
				else {
					for(int k=0; k<n; k++) {
						chk += (brr[j+k] * arr[k]);
					}
				}
				max = Math.max(max, chk);
			}
			
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}

}
