import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11509 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int cnt = 0;
		int[] res = new int[N+1];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			boolean chk = false;
			for(int j=cnt; j>=0; j--) {
				if(res[j] - 1 == arr[i]) {
					res[j] = arr[i];
					chk = true;
					break;
				}
			}
			if(chk) continue;
			res[++cnt] = arr[i];
		}
		
		System.out.println(cnt);
	}

}
