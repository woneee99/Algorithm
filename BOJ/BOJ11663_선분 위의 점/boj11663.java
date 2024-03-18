import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11663 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int s = 0, e = N-1;
			while(s <= e) {
				int mid = (s + e) / 2;
				if(arr[mid] < start) {
					s = mid + 1;
				}
				else e = mid - 1;
			}

			int startRes = s;
			s = 0; e = N-1;
			while(s <= e) {
				int mid = (s + e) / 2;
				if(arr[mid] > end) {
					e = mid - 1;
				}
				else s = mid + 1;
			}

			sb.append(e - startRes + 1).append("\n");
		}
		System.out.println(sb.toString());
	}

}
