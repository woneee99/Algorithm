import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj18429 {
	static int N, K, res;
	static int[] kit;
	static boolean[] chk;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // °¨¼Ò
		
		st = new StringTokenizer(br.readLine());
		kit = new int[N];
		chk = new boolean[N];
		for(int i=0; i<N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		
		cal(0, 500);
		System.out.println(res);
	}
	
	static void cal(int depth, int score) {
		if(depth == N) {
			res++;
			return;
		}
		
		score -= K;
		for(int i=0; i<N; i++) {
			if(chk[i]) continue;
			if(score + kit[i] < 500) continue;
			chk[i] = true;
			cal(depth+1, score+kit[i]);
			chk[i] = false;
		}
	}
}
