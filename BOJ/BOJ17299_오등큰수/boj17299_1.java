import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj17299_1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] count = new int[1_000_001];
		for(int i=0; i<N; i++) {
			int key = Integer.parseInt(st.nextToken());
			count[key]++;
			arr[i] = key;
		}
		
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[N];
		for(int i=N-1; i>=0; i--) {
			if(stack.isEmpty()) {
				res[i] = -1;
			}
			else if(count[stack.peek()] > count[arr[i]]) {
				res[i] = stack.peek();
			}
			else {
				boolean chk = false;
				while(!stack.isEmpty()) {
					if(count[stack.peek()] > count[arr[i]]) {
						res[i] = stack.peek();
						chk = true;
						break;
					}
					else stack.pop();
				}
				if(!chk) res[i] = -1;
			}
			stack.add(arr[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : res) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}

}
