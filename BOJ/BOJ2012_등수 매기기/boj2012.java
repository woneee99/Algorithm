import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2012 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] ex = new int[N+1];
		for(int i=1; i<=N; i++) {
			ex[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ex);
		long sum = 0;
		for(int i=1; i<=N; i++) {
			sum += Math.abs(ex[i]-i);
		}
		System.out.println(sum);
	}

}
