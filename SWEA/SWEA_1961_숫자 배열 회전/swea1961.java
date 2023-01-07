import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1961 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[n][n];
			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<n; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			String[] res = new String[n*n];
			Arrays.fill(res, "");
			int chk = 0;
			
			for(int j=0; j<n; j++) {
				for(int k=n-1; k>=0; k--) {
					res[chk] += arr[k][j]; 
				}
				chk++;
			}
			
			for(int j=n-1; j>=0; j--) {
				for(int k=n-1; k>=0; k--) {
					res[chk] += arr[j][k]; 
				}
				chk++;
			}
			
			for(int j=n-1; j>=0; j--) {
				for(int k=0; k<n; k++) {
					res[chk] += arr[k][j]; 
				}
				chk++;
			}
			
			sb.append("#").append(i).append("\n");
			for(int j=0; j<n; j++) {
				for(int k=j; k<n*n; k+=n) {
					sb.append(res[k]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
