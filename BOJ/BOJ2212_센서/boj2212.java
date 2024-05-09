import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2212 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int[] res = new int[N-1];
		for(int i=0; i<N-1; i++) {
			res[i] = arr[i+1] - arr[i];
		}
		
		Arrays.sort(res);
		long sum = 0;
		for(int i=0; i<N-K; i++) {
			sum += res[i];
		}
		
		System.out.println(sum);
	}

}
