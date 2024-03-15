import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj22862 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] perm = new int[N];
		for(int i=0; i<N; i++) {
			perm[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0, start = 0, oddNumCnt = 0;
		int res = 0;
		for(int i=0; i<N; i++) {
			if(perm[i] % 2 == 0) { // Â¦¼öÀÏ ¶§
				if(cnt == 0) start = i;
				cnt++;
				res = Math.max(res, cnt);
			}
			else if(cnt > 0){ // È¦¼ö ÀÌ°í, Â¦¼ö °ÅÄ£ Àû O
				oddNumCnt++;
				if(oddNumCnt > S) {
					while(perm[start] % 2 == 0) {
						cnt--;
						start++;
					}
					start++;
					oddNumCnt--;
				}
			}
		}
		System.out.println(res);
	}
}
