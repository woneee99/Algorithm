import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj20300 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] lose = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			lose[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(lose);
		
		long min = lose[N-1];
		for(int i=0; i<N/2; i++) {
			if(N % 2 == 1) {
				min = Math.max(lose[i] + lose[N - i - 2], min);
			}
			else {
				min = Math.max(lose[i] + lose[N - i - 1], min);
			}
		}
		System.out.println(min);
	}

}
