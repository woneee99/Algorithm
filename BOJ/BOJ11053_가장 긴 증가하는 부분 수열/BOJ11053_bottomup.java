import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []arr = new int[num];
		int []dp = new int[num];
		
		for(int i=0; i<num; i++) {		
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<num; i++) {
			dp[i] = 1;
			for(int j=0; j<i; i++) {
				if(arr[j] < arr[i] && dp[i] <= dp[j]) {
					dp[i] = dp[j] +1;
				}
			}
		}
		
		int max = -1;
		for(int i=0; i<num; i++) {
			max = dp[i] > max ? dp[i] : max;
		}
		System.out.println(max);
	}
}
