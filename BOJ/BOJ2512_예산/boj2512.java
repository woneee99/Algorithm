import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2512 {
	static int[] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long sum = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		int max = Integer.parseInt(br.readLine());
		
		if(sum <= max) {
			System.out.println(arr[n-1]);
			System.exit(0);
		}
		
		cal(0, max, max);
	}
	
	static void cal(int start, int end, int max) {
		int ans = 0;
		while(start <= end) {
			int mid = (start+end)/2;
			long cur = check(mid);
			
			if(cur > max) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
				ans = ans > mid ? ans : mid;
			}
		}
		System.out.println(ans);
	}
	
	static long check(int x) {
		long sum = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] >= x) sum += x;
			else sum += arr[i];
		}
		return sum;
	}
}
