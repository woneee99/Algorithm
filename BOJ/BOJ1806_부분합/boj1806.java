import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1806 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start =0, end=0;
		int cnt = 0, result = Integer.MAX_VALUE;
		long sum = 0;
		while(start <= end && end <= n) {
			if(sum < s) {
				sum += arr[end++];
				cnt++;
			}
			if(sum >= s) {
				result = cnt < result ? cnt : result;
				cnt--;
				sum -= arr[start++];
			}
		}
		result = (result == Integer.MAX_VALUE ) ? 0 : result;
		System.out.println(result);
	}

}
