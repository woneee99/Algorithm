import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj7795_1 {
	static int M;
	static int[] brr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			brr = new int[M];
			for(int i=0; i<M; i++) {
				brr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			Arrays.sort(brr);
			
			int cnt = 0, end = M-1;
			for(int i=N-1; i>=0; i--) {
				int res = bs(arr[i], end);
				end = res - 1;
				cnt += res;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int bs(int n, int end) {
		int start = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(brr[mid] < n) start = mid + 1;
			else end = mid - 1;
		}
		return start;
	}
}
