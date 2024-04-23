import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj20044 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int len = 2*n;
		int[] arr = new int[len];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<len; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int res = arr[0]+arr[len-1];
		for(int i=1; i<n; i++) {
			res = Math.min(res, arr[i] + arr[len-i-1]);
		}
		System.out.println(res);
	}

}