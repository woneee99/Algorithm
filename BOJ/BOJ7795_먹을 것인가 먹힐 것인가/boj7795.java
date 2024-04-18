import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj7795 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int[] brr = new int[M];
			for(int i=0; i<M; i++) {
				brr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			Arrays.sort(brr);
			
			int cnt = 0, end = M-1;
			for(int i=N-1; i>=0; i--) {
				while(end >= 0) {
					if(arr[i] > brr[end]) {
						break;
					}
					end--;
				}
				if(end < 0) break;
				cnt += end + 1;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}
