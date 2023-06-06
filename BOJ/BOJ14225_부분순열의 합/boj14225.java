import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14225 {
	static int N;
	static int[] arr;
	static boolean[] chk;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		chk = new boolean[100_000 * 20 + 1];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		cal(0, 0);
		
		for(int i=1; i<chk.length; i++) {
			if(!chk[i]) {
				System.out.println(i);
				break;
			}
		}
	}
	
	static void cal(int idx, int num) {
		if(idx == N) {
			chk[num] = true;
			return;
		}
		
		cal(idx+1, num+arr[idx]);
		cal(idx+1, num);
	}
}
