import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2847 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] level = new int[N];
		for(int i=0; i<N; i++) {
			level[i] = Integer.parseInt(br.readLine());
		}
		
		int min = 0;
		for(int i=N-2; i>=0; i--) {
			if(level[i+1] <= level[i]) {
				int cnt = level[i] - level[i+1] + 1;
				level[i] -= cnt;
				min += cnt;
			}
		}
		System.out.println(min);
	}

}
