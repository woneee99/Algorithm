import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int []arr;
	static int N;
	static int y = 0, max = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = max < arr[i]? arr[i] : max;
		}
		
		int standard = max;
		int mid = 0, ans =0;
		long tmp;
		while(y < standard) {
			
			mid = (y+standard)/2;
			tmp = cal(mid);
			
			if(tmp < M) {
				standard = mid;
			}
			else {
				ans = mid;
				y = mid + 1;
			}
		}
		System.out.println(ans);
	}
	
	
	static long cal(int height) {
		long ret = 0;
		
		for(int i=0; i<N; i++) {
			if(height < arr[i]) {
				ret += arr[i] - height;
			}
		}
		return ret;
	}
	
}
