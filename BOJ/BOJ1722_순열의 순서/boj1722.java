import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1722 {
	static int cnt, K;
	static long[] cmp;
	static int[] checkArr;
	static int[] res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		chk = new boolean[N+1];
		cmp = new long[N+1];
		
		cmp[0] = 1;
		for(int i=1; i<=N; i++) {
			cmp[i] = cmp[i-1] * i;
		}
		
		if(K == 1) {
			res = new int[N+1];
			long idx = Long.parseLong(st.nextToken());
			one(N, idx);
		}
		else {
			checkArr = new int[N+1];
			for(int i=1; i<=N; i++) {
				checkArr[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(two(N));
		}
	}
	
	static boolean[] chk;
	static void one(int N, long idx) {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(chk[j]) continue;
				if(cmp[N-i] < idx) {
					idx -= cmp[N-i];
				}
				else {
					chk[j] = true;
					res[i] = j;
					break;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(res[i] + " ");
		}
	}
	
	static long two(int N) {
		long idx = 1;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<checkArr[i]; j++) {
				if(chk[j]) continue;
				idx += cmp[N - i];
			}
			chk[checkArr[i]] = true;
		}
		return idx;
	}
}
