import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n+1];
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}
			
			int cut = arr[1], cnt = 1;
			for(int j=2; j<=n; j++) {
				if(arr[j] < cut) {
					cut = arr[j];
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}
