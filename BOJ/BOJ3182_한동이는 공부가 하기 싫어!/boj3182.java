import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj3182 {
	static int[] res;
	static boolean[] chk;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		res = new int[N+1];
		chk = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(br.readLine());
			res[i] = num;
		}
		
		for(int i=1; i<=N; i++) {
			cal(i, i, 0);
		}
		
		System.out.println(who);
	}
	static int max, who;
	static void cal(int n, int w, int cnt) {
		if(chk[n]) {
			if(max < cnt) {
				max = cnt;
				who = w;
			}
			return;
		}
		
		chk[n] = true;
		cal(res[n], w, cnt+1);
		chk[n] = false;
	}
}
