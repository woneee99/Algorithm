import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj21921 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long[] arr = new long[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = arr[i-1] + Long.parseLong(st.nextToken());
		}
		
		int cnt = 0;
		long max = 0;
		for(int i=X; i<=N; i++) {
			long num = arr[i] - arr[i-X];
			if(max < num) {
				max = num;
				cnt = 1;
			}
			else if(max != 0 && max == num) {
				cnt++;
			}
		}
		
		if(cnt == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
