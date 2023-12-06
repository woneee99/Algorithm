import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj3273 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int X = Integer.parseInt(br.readLine());
		
		int start = 0, end = N-1;
		int res = 0;
		while(start < end) {
			if(arr[start] + arr[end] == X) {
				res++;
				start++;
				end--;
			}
			else if(arr[start] + arr[end] > X) {
				end--;
			}
			else {
				start++;
			}
		}
		
		System.out.println(res);
	}

}
