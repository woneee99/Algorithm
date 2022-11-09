import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2467 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start = 0, end = n-1;
		int res = Integer.MAX_VALUE;
		int left = 0, right = 1_000_000_000;
		
		while(start < end) {
			int cur = arr[start] + arr[end];
			if(Math.abs(cur) < Math.abs(res)) {
				left = start; right = end;
				res = cur;
			}
			
			if(cur >= 0) {
				end--;
			}
			else {
				start++;
			}
		}
		
		System.out.println(arr[left] + " " + arr[right]);
	}
	
}
