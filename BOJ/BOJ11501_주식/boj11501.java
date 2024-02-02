import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11501 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long ans = 0; int max = 0;
			for(int i=N-1; i>=0; i--) {
				if(arr[i] > max) {
					max = arr[i];
				}
				else {
					ans += max - arr[i];
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
