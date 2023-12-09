import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13305 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] move = new long[N];
		for(int i=1; i<N; i++) {
			move[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		long[] amount = new long[N];
		for(int i=1; i<N; i++) {
			amount[i] = Long.parseLong(st.nextToken());
		}
		
		long money = 0;
		long min = amount[1];
		for(int i=1; i<N; i++) {
			min = min < amount[i] ? min : amount[i];
			money += min * move[i];
		}
		
		System.out.println(money);
	}
}
