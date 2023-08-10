import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11509_1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] res = new int[1_000_002];
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(res[arr[i]+1] == 0) {
				ans++;
			}
			else {
				res[arr[i]+1]--;
			}
			res[arr[i]]++;
		}
		
		System.out.println(ans);
	}

}
