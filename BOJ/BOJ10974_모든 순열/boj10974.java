import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj10974 {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		chk = new boolean[N+1];
		sb = new StringBuilder();
		cal(0);
		System.out.println(sb.toString());
	}
	
	static int[] arr;
	static boolean[] chk;
	static StringBuilder sb;
	static void cal(int depth) {
		if(depth == N) {
			for(int i=0; i<N; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(chk[i]) continue;
			chk[i] = true;
			arr[depth] = i;
			cal(depth+1);
			chk[i] = false;
		}
	}
}
