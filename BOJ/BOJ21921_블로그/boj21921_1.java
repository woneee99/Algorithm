import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj21921_1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i=0; i<X; i++) {
			sum += arr[i];
		}
		
		long max = sum;
		int cnt = 1;
		for(int i=X; i<N; i++) {
			sum += arr[i];
			sum -= arr[i-X];
			
			if(max < sum) {
				max = sum;
				cnt = 1;
			}
			else if(max != 0 && max == sum) {
				cnt++;
			}
		}
		
		if(max == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
