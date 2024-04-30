import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16401 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] snack = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 1, end = 1_000_000_001;
		while(start <= end) {
			int mid = (start + end) / 2;
			
			int cnt = 0;
			for(int i=N-1; i>=0; i--) {
				cnt += snack[i] / mid;
			}
			
			if(cnt >= M) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		System.out.println(start == 0 ? 0 : start-1);
	}
}
