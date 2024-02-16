import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2668 {
	static int[] arr;
	static boolean[] res, chk;
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		res = new boolean[N+1];
		chk = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			chk[i] = true;
			dfs(i, i);
			chk[i] = false;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		for(int i=1; i<=N; i++) {
			if(res[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int start, int target) {
		if(!chk[arr[target]]) {
			chk[arr[target]] = true;
			dfs(start, arr[target]);
			chk[arr[target]] = false;
		}
		if(arr[target] == start) {
			cnt++;
			res[start] = true;
		}
	}

}
