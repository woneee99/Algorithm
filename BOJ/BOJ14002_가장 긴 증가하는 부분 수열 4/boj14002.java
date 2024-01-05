import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj14002 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
					max = Math.max(dp[i], max);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n");
		
		Stack<Integer> stack = new Stack<>();
		for(int i=N; i>0; i--) {
			if(max == dp[i]) {
				stack.add(arr[i]);
				max--;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
