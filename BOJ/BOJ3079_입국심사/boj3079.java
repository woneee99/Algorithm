import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj3079 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		int[] time = new int[n];
		for(int i=0; i<n; i++) {
			time[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(time);
		
		long start = 0, end = m * time[n-1];
		long res = m * time[n-1];
		while(start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			for(int i : time) {
				long cal = mid / i;
				if(sum >= m) break;
				sum += cal;
			}
			
			if(sum >= m) {
				end = mid - 1;
				res = mid;
			}
			else start = mid + 1;
		}
		
		System.out.println(res);
	}

}
