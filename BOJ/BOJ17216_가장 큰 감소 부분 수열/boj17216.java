import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17216 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		dp[0] = arr[0];
		for(int i=1; i<N; i++) {
			dp[i] = arr[i];
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N]);
	}

}
