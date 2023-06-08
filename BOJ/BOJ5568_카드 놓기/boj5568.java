import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj5568 {
	static int[] arr;
	static int N, K;
	static HashSet<String> ts;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		chk = new boolean[N];
		ts = new HashSet<>();
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		cal(0, "");
		System.out.println(ts.size());
	}
	static boolean[] chk;
	static void cal(int depth, String str) {
		if(depth == K) {
			ts.add(str);
			return;
		}

		for(int i=0; i<N; i++) {
			if(chk[i]) continue;
			chk[i] = true;
			cal(depth+1, str + arr[i]);
			chk[i] = false;
		}
	}
}
