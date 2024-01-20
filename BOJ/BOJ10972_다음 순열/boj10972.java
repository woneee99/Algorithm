import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10972 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] perm = new int[N];
		for(int i=0; i<N; i++) {
			perm[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = -1;
		for(int i=N-1; i>0; i--) {
			if(perm[i] > perm[i-1]) {
				idx = i-1;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();	
		
		if(idx == -1) {
			sb.append("-1");
		}
		else {
			int min = 987654321, compIdx = 0;
			for(int i=idx+1; i<N; i++) {
				if(perm[idx] < perm[i] && min > perm[i]) {
					min = perm[i];
					compIdx = i;
				}
			}
			
			int temp = perm[idx];
			perm[idx] = perm[compIdx];
			perm[compIdx] = temp;
			
			Arrays.sort(perm, idx+1, N);
			
			for(int i=0; i<N; i++) {
				sb.append(perm[i]).append(" ");
			}
		}

		System.out.println(sb);
	}

}
