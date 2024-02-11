import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj11931 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=N-1; i>=0; i--) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}

}
